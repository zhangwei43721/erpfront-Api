package com.example.demo.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.pojo.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserService userService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getOne(new QueryWrapper<User>().eq("uname", username));
        
        if (user == null) {
            throw new UsernameNotFoundException("User not found with username: " + username);
        }

        return new org.springframework.security.core.userdetails.User(
                user.getUname(),
                user.getUpwd(),
                getAuthorities(user));
    }

    private Collection<? extends GrantedAuthority> getAuthorities(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        // 这里可以根据用户的角色或权限信息来添加权限
        // 例如：authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        if (user.getRids() != null && user.getRids().length > 0) {
            for (Integer roleId : user.getRids()) {
                authorities.add(new SimpleGrantedAuthority("ROLE_" + roleId));
            }
        } else {
            // 默认角色
            authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        }
        return authorities;
    }
}
