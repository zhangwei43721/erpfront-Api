package com.example.demo.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.example.demo.pojo.Menu;
import com.example.demo.vo.MenuVo;

import java.util.List;

/**
* @author skyforever
* @description 针对表【t_menu(前端菜单表)】的数据库操作Service
* @createDate 2025-05-13 16:01:20
*/
public interface MenuService extends IService<Menu> {

    /**
     * 查询并构建菜单树列表
     * @return 菜单树结构的Vo列表
     */
    List<MenuVo> queryMenuListService();

    /*添加菜单节点*/
    public void saveMenusService(Menu menu);
}
