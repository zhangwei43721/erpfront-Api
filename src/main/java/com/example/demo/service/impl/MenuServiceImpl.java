package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.mapper.MenuMapper;
import com.example.demo.pojo.Menu;
import com.example.demo.service.MenuService;
import com.example.demo.vo.MenuVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
* @author skyforever
* @description 针对表【t_menu(前端菜单表)】的数据库操作Service实现
* @createDate 2025-05-13 16:01:20
*/
@Service
public class MenuServiceImpl extends ServiceImpl<MenuMapper, Menu> implements MenuService {

    @Autowired
    private MenuMapper MenuMapper;

    @Override
    public List<MenuVo> queryMenuListService() {
        List<Menu> allMenu = this.list();// 查询所有菜单数据
        return buildSubmenu(allMenu, 0);
    }

    /**
     * 递归构建子菜单树
     *
     * @param allMenu 所有菜单的列表
     * @param parentId 当前要查找的父菜单ID
     * @return 指定父菜单ID下的子菜单树列表
     */
    private List<MenuVo> buildSubmenu(List<Menu> allMenu, Integer parentId) {
        List<MenuVo> submenuTree = new ArrayList<>();

        for (Menu menu : allMenu) {
            // 检查当前菜单的父ID是否与传入的parentId匹配
            if (menu.getPid() != null && menu.getPid().equals(parentId)) {
                MenuVo menuVo = new MenuVo();
                BeanUtils.copyProperties(menu, menuVo); // 将 POJO属性 复制到 VO
                // 递归查找当前菜单的子菜单
                menuVo.setSubMenu(buildSubmenu(allMenu, menu.getId()));
                submenuTree.add(menuVo);
            }
        }
        return submenuTree;
    }
    @Override
    public void saveMenusService(Menu menu) {


        QueryWrapper<Menu> wrapper=new QueryWrapper<>();
        wrapper.select("max(component) maxv");
        //获得component的最大值
        Menu ms = MenuMapper.selectOne(wrapper);

        //component组件属性的值，是数据库最大值加1
        menu.setComponent(ms.getMaxv()+1);
        MenuMapper.insert(menu);

    }
}



