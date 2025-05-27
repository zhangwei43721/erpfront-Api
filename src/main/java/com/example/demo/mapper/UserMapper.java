package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.demo.pojo.User;

/**
 * @author skyforever
 * @description 针对表【t_user(用户信息表 (系统用户))】的数据库操作Mapper
 * @createDate 2025-05-22 09:43:40
 * @Entity com.example.demo.pojo.User
 */
public interface UserMapper extends BaseMapper<User> {

    /*保存用户信息*/
    void saveUserMapper(User user);
}




