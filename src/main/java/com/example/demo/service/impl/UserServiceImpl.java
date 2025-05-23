package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.UserMapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
    @Override
    public Map<String, Object> queryUserListService(Integer pageNum, Integer pageSize) {
        Map<String, Object> result=new HashMap<>();
        //指定分页参数
        Page<User> page=new Page<>(pageNum,pageSize);
        List<User> userList = userMapper.selectList(page, null);

        result.put("total",page.getTotal());
        result.put("userList",userList);
        return result;
    }
}




