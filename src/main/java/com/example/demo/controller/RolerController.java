package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.pojo.Roler;
import com.example.demo.service.RoleMenuService;
import com.example.demo.service.RolerService;
import com.example.demo.util.ResponseUtil;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class RolerController {

    private final RolerService rolerService;

    private final RoleMenuService roleMenuService;

    public RolerController(RolerService rolerService, RoleMenuService roleMenuService) {
        this.rolerService = rolerService;
        this.roleMenuService = roleMenuService;
    }

    /*加载所有角色信息*/
    @GetMapping("/loadAllRoles")
    public List<Roler> loadAllRoles() {
        QueryWrapper<Roler> wrapper = new QueryWrapper<>();
        wrapper.select("id", "rname");
        return rolerService.list(wrapper);
    }

    /*处理分页查询请求*/
    @GetMapping("/rolerList")
    public Map<String, Object> rolerList(
            @RequestParam(defaultValue = "1") Integer pageNum,
            @RequestParam(defaultValue = "10") Integer pageSize) {
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
        if (roleMenuService.grantRoleMenus(ids)) {
            return ResponseUtil.success("授权成功.......");
        } else {
            return ResponseUtil.error(400, "授权失败......");
        }
    }

    /*处理角色信息修改的请求*/
    @PostMapping("/updateRoler")
    public Map<String, Object> updateRoler(@RequestBody Roler roler) {
        boolean success = rolerService.updateById(roler);
        if (success) {
            return ResponseUtil.success("更新角色信息成功");
        } else {
            return ResponseUtil.error(400, "操作失败");
        }
    }

    /*处理角色信息添加的请求*/
    @PostMapping("/saveRoler")
    public Map<String, Object> saveRoler(@RequestBody Roler roler) {
        rolerService.save(roler);
        return ResponseUtil.success("保存角色信息成功");
    }

    /*处理角色信息删除的请求*/
    @PostMapping("/deleteRoler")
    public Map<String, Object> deleteRoler(@RequestBody Roler roler) {
        rolerService.deleteRolerAndMenus(roler.getId());
        return ResponseUtil.success("删除角色信息成功......");
    }
}