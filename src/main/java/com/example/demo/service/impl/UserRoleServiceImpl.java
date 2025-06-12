package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.UserRoleMapper;
import com.example.demo.pojo.UserRole;
import com.example.demo.service.UserRoleService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author skyforever
 * @description 针对表【t_user_role(用户角色关联表 (分配用户角色))】的数据库操作Service实现
 * @createDate 2025-05-22 09:43:40
 */
@Service
public class UserRoleServiceImpl extends ServiceImpl<UserRoleMapper, UserRole>
        implements UserRoleService {

    @Override
    public List<Integer> listRoleIdsByUserId(Long userId) {
        if (userId == null) {
            return Collections.emptyList();
        }

        List<UserRole> userRoles = this.lambdaQuery()
                .select(UserRole::getRid)
                .eq(UserRole::getUid, userId)
                .list();

        if (CollectionUtils.isEmpty(userRoles)) {
            return Collections.emptyList();
        }

        return userRoles.stream()
                .map(UserRole::getRid)
                .collect(Collectors.toList());
    }

    @Override
    public boolean removeByUserId(Long userId) {
        if (userId == null) {
            return false;
        }
        return this.lambdaUpdate()
                .eq(UserRole::getUid, userId)
                .remove();
    }
}




