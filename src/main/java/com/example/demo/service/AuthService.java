package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.pojo.User;
import com.example.demo.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final UserService userService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;
    private final JwtUtil jwtUtil;
    private final UserDetailsService userDetailsService;

    @Transactional
    public void register(LoginRequest registerRequest) {
        // 检查用户名是否已存在
        if (userService.getOne(new QueryWrapper<User>().eq("uname", registerRequest.getUsername())) != null) {
            throw new IllegalArgumentException("用户名已被使用");
        }

        // 创建新用户
        User user = new User();
        user.setUname(registerRequest.getUsername());
        user.setUpwd(passwordEncoder.encode(registerRequest.getPassword()));
        
        userService.save(user);
    }

    public JwtResponse login(LoginRequest loginRequest) {
        try {
            // 使用Spring Security进行认证
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);
            
            // 生成JWT令牌
            final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUsername());
            final String token = jwtUtil.generateToken(userDetails);
            
            // 获取用户ID
            User user = userService.getOne(new QueryWrapper<User>().eq("uname", loginRequest.getUsername()));
            
            if (user == null) {
                throw new BadCredentialsException("用户不存在");
            }
            
            return JwtResponse.builder()
                    .token(token)
                    .expiresIn(Math.toIntExact(jwtUtil.getExpirationDateFromToken(token).getTime() / 1000))
                    .userId(user.getId())
                    .username(user.getUname())
                    .build();
            
        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("用户名或密码错误", e);
        } catch (Exception e) {
            throw new RuntimeException("登录失败: " + e.getMessage(), e);
        }
    }
}
