package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.pojo.RoleMenu;
import com.example.demo.service.RoleMenuService;
import com.example.demo.mapper.RoleMenuMapper;
import org.springframework.stereotype.Service;

/**
* @author skyforever
* @description 针对表【t_role_menu(角色菜单关联表 (定义角色拥有的菜单权限))】的数据库操作Service实现
* @createDate 2025-05-22 09:43:40
*/
@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu>
    implements RoleMenuService{

}




