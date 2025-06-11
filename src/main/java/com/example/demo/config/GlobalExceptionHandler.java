package com.example.demo.config;

import com.example.demo.util.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Map;

@ControllerAdvice
@ResponseBody //确保返回的是JSON
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public Map<String, Object> handleGlobalException(Exception e) {
        logger.error("发生未捕获异常: ", e);
        return R.error(500, "服务器内部错误，请稍后再试或联系管理员");
    }

    @ExceptionHandler(BadCredentialsException.class)
    @ResponseStatus(HttpStatus.UNAUTHORIZED)
    public Map<String, Object> handleBadCredentialsException(BadCredentialsException e) {
        logger.warn("登录失败: {}", e.getMessage());
        return R.error(401, "用户名或密码错误");
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public Map<String, Object> handleUsernameNotFoundException(UsernameNotFoundException e) {
        logger.warn("用户不存在: {}", e.getMessage());
        return R.error(404, "用户不存在");
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleIllegalArgumentException(IllegalArgumentException e) {
        logger.warn("无效参数: {}", e.getMessage());
        return R.error(400, e.getMessage());
    }

    @ExceptionHandler(RuntimeException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public Map<String, Object> handleRuntimeException(RuntimeException e) {
        logger.error("业务异常: {}", e.getMessage(), e);
        return R.error(400, e.getMessage());
    }
}