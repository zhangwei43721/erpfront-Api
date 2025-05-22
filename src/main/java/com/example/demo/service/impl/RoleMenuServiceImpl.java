package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.RoleMenuMapper;
import com.example.demo.pojo.RoleMenu;
import com.example.demo.service.RoleMenuService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoleMenuServiceImpl extends ServiceImpl<RoleMenuMapper, RoleMenu>
    implements RoleMenuService{

    @Override
    public List<Integer> getMenusByRoleId(Integer roleId) {
        return baseMapper.getMenusByRoleId(roleId);
    }

    @Override
    public boolean grantRoleMenus(Integer[] ids) {
        if (ids.length > 0) {
            Integer roleId = ids[0];
            List<Integer> menuIds = new ArrayList<>();
            for(int i=1; i<ids.length; i++) {
                menuIds.add(ids[i]);
            }
            // 先删除原有权限
            baseMapper.deleteByRoleId(roleId);
            // 批量插入新权限
            if (menuIds != null && !menuIds.isEmpty()) {
                return baseMapper.batchInsert(roleId, menuIds) > 0;
            }
            return true;
        }
        return false;
    }
}
