package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.MenuMapper;
import com.example.demo.pojo.Menu;
import com.example.demo.service.MenuService;
import com.example.demo.vo.MenuVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper menuMapper;

    @Override
    public List<MenuVo> queryMenuListService() {
        QueryWrapper<Menu> queryWrapper = new QueryWrapper<>();
        // 按 pid 升序，再按 sort_order 升序
        queryWrapper.orderByAsc("pid", "sort_order");
        List<Menu> allMenu = this.list(queryWrapper);
        return buildSubmenu(allMenu, 0); // 假设根节点的 pid 为 0
    }

    private List<MenuVo> buildSubmenu(List<Menu> allMenu, Integer parentId) {
        List<MenuVo> submenuTree = new ArrayList<>();
        // 直接从已排序的 allMenu 中筛选，它们自然保持了 sort_order 的顺序
        for (Menu menu : allMenu) {
            if (menu.getPid() != null && menu.getPid().equals(parentId)) {
                MenuVo menuVo = new MenuVo();
                BeanUtils.copyProperties(menu, menuVo);
                // 递归查找子菜单时，子菜单也已经是排序好的了
                menuVo.setSubMenu(buildSubmenu(allMenu, menu.getId()));
                submenuTree.add(menuVo);
            }
        }
        return submenuTree;
    }

    @Override
    public void saveMenusService(Menu menu) {
        QueryWrapper<Menu> wrapper = new QueryWrapper<>();
        wrapper.select("max(component) maxv");
        Menu ms = menuMapper.selectOne(wrapper);
        menu.setComponent(ms == null || ms.getMaxv() == null ? 0 : ms.getMaxv() + 1); // 处理ms或maxv为null的情况

        // 设置新菜单的 sort_order，例如排在同级最后
        QueryWrapper<Menu> countWrapper = new QueryWrapper<>();
        countWrapper.eq("pid", menu.getPid());
        long count = this.count(countWrapper);
        menu.setSortOrder((int) count);

        menuMapper.insert(menu);
    }

    // 新增方法：用于处理前端拖拽后的顺序更新
    @Transactional // 保证操作的原子性
    @Override
    public void updateMenusOrder(List<MenuVo> menuUpdates) { // 直接使用MenuVo作为DTO，或者创建一个专门的DTO
        if (menuUpdates == null || menuUpdates.isEmpty()) {
            return;
        }
        for (MenuVo menuUpdate : menuUpdates) {
            if (menuUpdate.getId() == null) continue; // ID 不能为空

            UpdateWrapper<Menu> updateWrapper = new UpdateWrapper<>();
            updateWrapper.eq("id", menuUpdate.getId())
                    .set("pid", menuUpdate.getPid())
                    .set("sort_order", menuUpdate.getSortOrder());
            // 如果 label 也可能在前端修改并需要同步，可以加上
            // if (menuUpdate.getLabel() != null) {
            //    updateWrapper.set("label", menuUpdate.getLabel());
            // }
            this.update(null, updateWrapper);
        }
    }
}