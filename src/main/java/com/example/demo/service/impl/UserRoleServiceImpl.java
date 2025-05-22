package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.UserRole;
import com.example.demo.service.UserRoleService;
import com.example.demo.mapper.UserRoleMapper;
import org.springframework.stereotype.Service;

/**
* @author skyforever
* @description 针对表【t_user_role(用户角色关联表 (分配用户角色))】的数据库操作Service实现
* @createDate 2025-05-22 09:43:40
*/
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
    implements UserRoleService{

}




