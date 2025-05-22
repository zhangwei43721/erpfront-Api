package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.RoleMenu;

import java.util.List;

/**
 * @author skyforever
 * @description 针对表【t_role_menu(角色菜单关联表 (定义角色拥有的菜单权限))】的数据库操作Service
 * @createDate 2025-05-22 09:43:40
 */
public interface RoleMenuService extends IService<RoleMenu> {

    List<Integer> getMenusByRoleId(Integer roleId);

    boolean grantRoleMenus(Integer[] ids);
}