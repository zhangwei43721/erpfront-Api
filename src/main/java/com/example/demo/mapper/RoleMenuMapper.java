package com.example.demo.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * 角色菜单关联表 Mapper 接口
 * </p>
 *
 * @author author
 * @since 2024-11-18
 */
public interface RoleMenuMapper extends BaseMapper<com.example.demo.pojo.RoleMenu> {
    List<Integer> getMenusByRoleId(Integer roleId);

    int deleteByRoleId(Integer roleId);

    int batchInsert(Integer roleId, List<Integer> menuIds);
}