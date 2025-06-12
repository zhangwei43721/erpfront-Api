package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.dto.CountResult;
import com.example.demo.pojo.User;
import com.example.demo.vo.MenuVo;

import java.util.List;
import java.util.Map;

/**
 * @author skyforever
 * @description 针对表【t_user(用户信息表 (系统用户))】的数据库操作Service
 * @createDate 2025-05-22 09:43:40
 */
public interface UserService extends IService<User> {

    /*根据用户名查询用户信息*/
    User findByUsername(String username);

    /*实现用户信息分页查询*/
    Map<String, Object> queryUserListService(Integer pageNum, Integer pageSize);

    /*实现用户信息保存*/
    void saveUserRolerService(User user);

    /*更新用户信息*/
    void updateUserRoleService(User user);

    /*实现用户信息的删除*/
    void deleteUserRoleService(Long id);

    /*实现员工按照年龄段分布统计*/
    List<CountResult> countEmployeeAageService();

    /*实现员工学历分布统计*/
    List<CountResult> countEmployeeEduService();

    /*加载左侧导航菜单，根据当前用户加载*/
    List<MenuVo> queryUserMenusListService(Long uid);

}
