package com.example.demo.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserRoleService;
import com.example.demo.service.UserService;
import com.example.demo.util.R;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
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
    public List<Integer> queryUserRids(@PathVariable Integer id) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("uid", id);
        wrapper.select("rid");
        return userRoleService.listObjs(wrapper);
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
        userService.deleteUserRoleService(user.getId());
        return R.success("删除用户信息成功");
    }
}