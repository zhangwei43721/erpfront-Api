package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.Roler;

import java.util.Map;

/**
 * @author skyforever
 * @description 针对表【t_roler(角色信息表 (权限管理))】的数据库操作Service
 * @createDate 2025-05-22 09:43:40
 */
public interface RolerService extends IService<Roler> {

    Map<String, Object> queryRolePageListService(Integer pageNum, Integer pageSize);

    /**
     * 删除角色及其关联的菜单权限
     *
     * @param rolerId 角色ID
     * @throws RuntimeException 如果角色不存在或删除失败（可选，取决于你的错误处理策略）
     */
    void deleteRolerAndMenus(Integer rolerId);
}
