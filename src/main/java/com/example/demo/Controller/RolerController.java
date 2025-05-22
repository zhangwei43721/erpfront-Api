package com.example.demo.Controller;

import com.example.demo.pojo.Roler;
import com.example.demo.service.RoleMenuService;
import com.example.demo.service.RolerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class RolerController {
    @Autowired
    private RolerService rolerService;

    @Autowired
    private RoleMenuService roleMenuService;

    /*处理分页查询请求*/
    @GetMapping("/rolerList")
    public Map<String, Object> rolerList(
            @RequestParam(defaultValue = "1") Integer pageNum
            , @RequestParam(defaultValue = "10") Integer pageSize) {
        return rolerService.queryRolePageListService(pageNum, pageSize);
    }

    /*获取角色菜单权限接口*/
    @GetMapping("/listRoleMenus")
    public List<Integer> listRoleMenus(Integer roleId) {
        return roleMenuService.getMenusByRoleId(roleId);
    }

    /*授予角色菜单权限接口*/
    @PostMapping("/grantRoleMenus")
    public Map<String, Object> grantRoleMenus(@RequestBody Integer[] ids) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "授权失败......");
        try {
            if (roleMenuService.grantRoleMenus(ids)) {
                result.put("code", 200);
                result.put("msg", "授权成功.......");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /*处理角色信息修改的请求*/
    @PostMapping("/updateRoler")
    public Map<String, Object> updateRoler(@RequestBody Roler roler) {

        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "操作失败.......");
        try {
            rolerService.updateById(roler);
            result.put("code", 200);
            result.put("msg", "更新角色信息成功......");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;

    }

    /*处理角色信息添加的请求*/
    @PostMapping("/saveRoler")
    public Map<String, Object> saveRoler(@RequestBody Roler roler) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "操作失败.......");
        try {
            rolerService.save(roler);
            result.put("code", 200);
            result.put("msg", "保存角色信息成功......");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    /*处理角色信息删除的请求*/
    @PostMapping("/deleteRoler")
    public Map<String, Object> deleteRoler(@RequestBody Roler roler) {
        Map<String, Object> result = new HashMap<>();
        result.put("code", 400);
        result.put("msg", "操作失败.......");
        try {
            rolerService.removeById(roler.getId());
            result.put("code", 200);
            result.put("msg", "删除角色信息成功......");
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }
}
