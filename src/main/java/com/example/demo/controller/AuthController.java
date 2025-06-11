package com.example.demo.controller;

import com.example.demo.dto.JwtResponse;
import com.example.demo.dto.LoginRequest;
import com.example.demo.service.AuthService;
import com.example.demo.util.R;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        JwtResponse response = authService.login(loginRequest);
        return ResponseEntity.ok(R.success("登录成功").put("data", response));
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody LoginRequest signUpRequest) {
        authService.register(signUpRequest);
        return ResponseEntity.ok(R.success("用户注册成功"));
    }
}
