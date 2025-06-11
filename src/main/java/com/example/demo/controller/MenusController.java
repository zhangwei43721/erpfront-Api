package com.example.demo.controller;

import com.example.demo.pojo.Menu;
import com.example.demo.service.MenuService;
import com.example.demo.util.R;
import com.example.demo.vo.MenuVo;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class MenusController {

    private final MenuService menuService;

    public MenusController(MenuService menuService) {
        this.menuService = menuService;
    }

    /*定义方法处理，加载左侧菜单节点的请求*/
    @RequestMapping("/listMenus")
    public List<MenuVo> listMenus() {
        return menuService.queryMenuListService();
    }

    /*定义方法处理，加载左侧菜单节点的对应的组件下标的请求*/
    @RequestMapping("/compIndex") // 可以用 @GetMapping
    public Integer compIndex(@RequestParam Integer id) { // 明确使用 @RequestParam
        Menu menu = menuService.getById(id);
        if (menu != null) {
            return menu.getComponent();
        }
        return null;
    }

    /*处理菜单节点信息的添加请求*/
    @PostMapping("/saveMenus")
    public Map<String, Object> saveMenus(@RequestBody Menu menu) {
        menuService.saveMenusService(menu);
        return R.success("添加菜单节点成功.......");
    }

    /*处理菜单单个节点信息的修改请求*/
    @PutMapping("/updateMenus")
    public Map<String, Object> updateMenus(@RequestBody Menu menu) {
        boolean updated = menuService.updateById(menu);
        if (updated) {
            return R.success("修改菜单节点成功.......");
        } else {
            return R.error(400, "操作失败......");
        }
    }

    /*处理菜单节点信息的修改请求 (顺序)*/
    @PostMapping("/updateMenusOrder")
    public Map<String, Object> updateMenusOrder(@RequestBody List<MenuVo> menuUpdates) {
        menuService.updateMenusOrder(menuUpdates);
        return R.success("菜单顺序更新成功!");
    }

    /*处理菜单节点信息的删除请求*/
    @DeleteMapping("/deleteMenus")
    public Map<String, Object> deleteMenus(@RequestParam Integer id) {
        boolean deleted = menuService.removeById(id);
        if (deleted) {
            return R.success("删除菜单节点成功");
        } else {
            return R.error(400, "操作失败");
        }
    }
}