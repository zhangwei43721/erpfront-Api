package com.example.demo.controller;

import com.example.demo.dto.CountResult;
import com.example.demo.pojo.User;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;
import com.example.demo.util.R;
import com.example.demo.vo.MenuVo;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
public class UserController {
    private final UserService userService;

    private final UserRoleService userRoleService;

    public UserController(UserService userService, UserRoleService userRoleService) {
        this.userService = userService;
        this.userRoleService = userRoleService;
    }


    /*处理用户信息分页查询氢气*/
    @GetMapping("/userList")
    public Map<String, Object> userList(
            @RequestParam(defaultValue = "1") Integer pageNum
            , @RequestParam(defaultValue = "10") Integer pageSize) {
        return userService.queryUserListService(pageNum, pageSize);
    }

    /*添加方法处理用户信息添加请求*/
    @PostMapping("/saveUser")
    public Map<String, Object> saveUser(@RequestBody User user) {
        userService.saveUserRolerService(user);
        return R.success("保存用户信息成功");
    }

    /*根据用户id查询某个用户的所有角色id*/
    @GetMapping("/queryUserRids/{id}")
    public List<Integer> queryUserRids(@PathVariable Long id) {
        return userRoleService.listRoleIdsByUserId(id);
    }

    /*处理用户信息修改请求*/
    @PostMapping("/updateUser")
    public Map<String, Object> updateUser(@RequestBody User user) {
        userService.updateUserRoleService(user);
        return R.success("修改用户信息成功");
    }

    /*处理用户信息删除请求*/
    @PostMapping("/deleteUser")
    public Map<String, Object> deleteUser(@RequestBody User user) {
        if (user.getId() != null) {
            userService.deleteUserRoleService(user.getId());
            return R.success("删除用户信息成功");
        }
        return R.error("用户ID不能为空");
    }

    /*处理员工年龄分部统计请求*/
    @GetMapping("/countEmpAge")
    public List<CountResult> countEmpAge() {
        return userService.countEmployeeAageService();
    }

    /*处理员工学历分布统计的请求*/
    @GetMapping("/countEmpEdu")
    public List<CountResult> countEmpEdu() {
        return userService.countEmployeeEduService();
    }

    /* 处理加载当前登录用户菜单的请求 */
    @GetMapping("/queryUserMenus")
    public List<MenuVo> queryUserMenus() {
        // 从 SecurityContextHolder 获取当前登录用户
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.getPrincipal() instanceof UserDetails userDetails) {
            // 假设 UserService 提供方法根据 username 获取用户
            User user = userService.findByUsername(userDetails.getUsername());
            return userService.queryUserMenusListService(user.getId());
        }
        throw new IllegalArgumentException("用户未登录");
    }
}