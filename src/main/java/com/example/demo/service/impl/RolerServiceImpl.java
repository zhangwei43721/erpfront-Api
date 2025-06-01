package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.RolerMapper;
import com.example.demo.pojo.RoleMenu;
import com.example.demo.pojo.Roler;
import com.example.demo.service.RoleMenuService;
import com.example.demo.service.RolerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author skyforever
 * @description 针对表【t_roler(角色信息表 (权限管理))】的数据库操作Service实现
 * @createDate 2025-05-22 09:43:40
 */
@Service
public class RolerServiceImpl extends ServiceImpl<RolerMapper, Roler>
        implements RolerService {

    private RolerMapper rolerMapper;

    private final RoleMenuService roleMenuService; // 用于操作 RoleMenu

    public RolerServiceImpl(RoleMenuService roleMenuService) {
        this.roleMenuService = roleMenuService;
    }

    @Autowired
    public RolerServiceImpl(RolerMapper rolerMapper) {
        this.rolerMapper = rolerMapper;
    }

    @Override
    public Map<String, Object> queryRolePageListService(Integer pageNum, Integer pageSize) {
        //指定分页查询参数
        Page<Roler> page = new Page<>(pageNum, pageSize);
        List<Roler> rolerList = rolerMapper.selectList(page, null);

        Map<String, Object> result = new HashMap<>();
        result.put("total", page.getTotal());
        result.put("rolerList", rolerList);
        return result;
    }

    @Override
    @Transactional // 确保操作的原子性
    public void deleteRolerAndMenus(Integer rolerId) {
        // 1. （可选）检查角色是否存在
        Roler roler = this.getById(rolerId);
        if (roler == null) {
            // 如果角色不存在，根据业务需求决定是静默处理还是抛异常
            // 抛出异常会被全局异常处理器捕获
            throw new RuntimeException("要删除的角色不存在, ID: " + rolerId);
        }
        // 2. 删除角色关联的菜单权限 (t_role_menu 表中的记录)
        QueryWrapper<RoleMenu> roleMenuQueryWrapper = new QueryWrapper<>();
        roleMenuQueryWrapper.eq("rid", rolerId);
        roleMenuService.remove(roleMenuQueryWrapper); // 假设 RoleMenuService 继承了 IService<RoleMenu>

        // 3. 删除角色本身 (t_roler 表中的记录)
        boolean removed = this.removeById(rolerId);
        if (!removed) { // roler!=null 确保不是因为第一步检查前就删了
            // 如果上面 getById 成功，但这里删除失败，可能是并发或数据库问题
            throw new RuntimeException("删除角色信息失败, ID: " + rolerId);
        }
    }

}




