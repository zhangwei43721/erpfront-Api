package com.example.demo.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

/**
 * 角色菜单关联表 (定义角色拥有的菜单权限)
 *
 * @TableName t_role_menu
 */
@TableName(value = "t_role_menu")
@Data
public class RoleMenu {
    /**
     * 关联ID (主键)
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 角色ID (关联t_roler.id)
     */
    private Integer rid;

    /**
     * 菜单ID (关联t_menus.id)
     */
    private Integer mid;
}