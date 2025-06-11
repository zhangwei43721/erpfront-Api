package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.dto.CountResult;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.pojo.UserRole;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author skyforever
 * @description 针对表【t_user(用户信息表 (系统用户))】的数据库操作Service实现
 * @createDate 2025-05-22 09:43:40
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User>
        implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private UserRoleService userRoleService;

    @Override
    public Map<String, Object> queryUserListService(Integer pageNum, Integer pageSize) {
        Map<String, Object> result = new HashMap<>();
        //指定分页参数
        Page<User> page = new Page<>(pageNum, pageSize);
        List<User> userList = userMapper.selectList(page, null);

        result.put("total", page.getTotal());
        result.put("userList", userList);
        return result;
    }

    @Transactional
    @Override
    public void saveUserRolerService(User user) {
        // 保存用户基本信息后需要获得数据库自增产生的用户id
        userMapper.saveUserMapper(user);
        
        // 获得当前用户分配的角色id的集合,从前台提交
        Integer[] rids = user.getRids();
        if (rids != null) {
            for (Integer rid : rids) {
                // 保存用户和角色的关系
                UserRole ur = new UserRole();
                ur.setUid(user.getId()); // 用户id赋值
                ur.setRid(rid); // 角色id赋值
userRoleService.save(ur);
            }
        }
    }

    @Transactional
    @Override
    public void updateUserRoleService(User user) {
        // 删除当前更新用户和角色的所有关系，断开关系
        userRoleService.removeByUserId(user.getId());

        // 更新用户信息
        userMapper.updateById(user);

        // 中间关系表重新添加数据
        Integer[] rids = user.getRids();
        if (rids != null) {
            for (Integer rid : rids) {
                UserRole ur = new UserRole();
                ur.setUid(user.getId());
                ur.setRid(rid);
                userRoleService.save(ur);
            }
        }
    }

    @Transactional
    @Override
    public void deleteUserRoleService(Long id) {
        // 删除用户
        userMapper.deleteById(id);

        // 删除用户角色信息
        userRoleService.removeByUserId(id);
    }

    @Override
    public List<CountResult> countEmployeeAageService() {
        return userMapper.countEmployeeAageMapper();
    }

    @Override
    public List<CountResult> countEmployeeEduService() {
        return userMapper.countEmployeeEduMapper();
    }
}




