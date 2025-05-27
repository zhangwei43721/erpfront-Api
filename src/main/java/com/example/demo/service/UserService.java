package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.User;

import java.util.Map;

/**
 * @author skyforever
 * @description 针对表【t_user(用户信息表 (系统用户))】的数据库操作Service
 * @createDate 2025-05-22 09:43:40
 */
public interface UserService extends IService<User> {

    /*实现用户信息分页查询*/
    Map<String, Object> queryUserListService(Integer pageNum, Integer pageSize);

    /*实现用户信息保存*/
    void saveUserRolerService(User user);

    /*更新用户信息*/
    void updateUserRoleService(User user);

    /*实现用户信息的删除*/
    void deleteUserRoleService(Integer id);

}
