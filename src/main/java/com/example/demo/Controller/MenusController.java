package com.example.demo.Controller;

import com.example.demo.pojo.Menu;
import com.example.demo.service.MenuService;
import com.example.demo.vo.MenuVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MenusController {

    @Autowired
    private MenuService menuService;

    /*定义方法处理，加载左侧菜单节点的请求*/
    @CrossOrigin
    @RequestMapping("/listMenus")
    public List<MenuVo> listMenus(){
        return menuService.queryMenuListService();
    }
    /*定义方法处理，加载左侧菜单节点的对应的组件下标的请求*/
    @CrossOrigin
    @RequestMapping("/compIndex")
    public Integer compIndex(Integer id){
        Menu menus = menuService.getById(id);
        return menus.getComponent();
    }

    /*处理菜单节点信息的添加请求*/
    @CrossOrigin
    @PostMapping("/saveMenus")
    public Map<String,Object> saveMenus(@RequestBody Menu menu){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try{
            menuService.saveMenusService(menu);
            result.put("code",200);
            result.put("msg","添加菜单节点成功.......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /*处理菜单单个节点信息的修改请求*/
    @CrossOrigin
    @PutMapping("/updateMenus")
    public Map<String,Object> updateMenus(@RequestBody Menu menu){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try{
            menuService.updateById(menu);
            result.put("code",200);
            result.put("msg","修改菜单节点成功.......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /*处理菜单节点信息的修改请求*/
    @CrossOrigin
    @PostMapping("/updateMenusOrder")
    public Map<String,Object> updateMenusOrder(@RequestBody List<MenuVo> menuUpdates){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","菜单顺序更新失败!");
        try{
            menuService.updateMenusOrder(menuUpdates);
            result.put("code",200);
            result.put("msg","菜单顺序更新成功!");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }
    /*处理菜单节点信息的删除请求*/
    @CrossOrigin
    @DeleteMapping("/deleteMenus")
    public Map<String,Object> deleteMenus(Integer id){
        Map<String,Object> result=new HashMap<>();
        result.put("code",400);
        result.put("msg","操作失败......");
        try{
            menuService.removeById(id);
            result.put("code",200);
            result.put("msg","删除菜单节点成功.......");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return result;
    }


}