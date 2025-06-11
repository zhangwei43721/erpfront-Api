package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.UserRole;

import java.util.List;

/**
 * @author skyforever
 * @description 针对表【t_user_role(用户角色关联表 (分配用户角色))】的数据库操作Service
 * @createDate 2025-05-22 09:43:40
 */
public interface UserRoleService extends IService<UserRole> {
    
    /**
     * 根据用户ID查询角色ID列表
     * @param userId 用户ID
     * @return 角色ID列表
     */
    List<Integer> listRoleIdsByUserId(Long userId);
    
    /**
     * 根据用户ID删除用户角色关联
     * @param userId 用户ID
     * @return 是否删除成功
     */
    boolean removeByUserId(Long userId);
}
