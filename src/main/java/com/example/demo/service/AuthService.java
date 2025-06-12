package com.example.demo.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.pojo.CustomUserDetails;
import com.example.demo.pojo.User;
import com.example.demo.util.JwtUtil;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
            Authentication authentication = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(
                            loginRequest.getUsername(),
                            loginRequest.getPassword()
                    )
            );

            SecurityContextHolder.getContext().setAuthentication(authentication);

            // 从认证结果中直接获取 CustomUserDetails
            CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();

            final String token = jwtUtil.generateToken(userDetails);

            return JwtResponse.builder()
                    .token(token)
                    .expiresIn(Math.toIntExact(jwtUtil.getExpirationDateFromToken(token).getTime() / 1000))
                    .userId(userDetails.getId()) // 直接从 UserDetails 获取 ID
                    .username(userDetails.getUsername())
                    .build();

        } catch (BadCredentialsException e) {
            throw new BadCredentialsException("用户名或密码错误", e);
        } catch (Exception e) {
            throw new RuntimeException("登录失败: " + e.getMessage(), e);
        }
    }
}
