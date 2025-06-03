package com.example.demo.config;

import com.example.demo.util.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@ControllerAdvice
@ResponseBody //确保返回的是JSON
public class GlobalExceptionHandler {

    private static final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(Exception.class)
    public Map<String, Object> handleGlobalException(Exception e) {
        logger.error("发生未捕获异常: ", e); // 记录日志
        return R.error(500, "服务器内部错误，请稍后再试或联系管理员");
    }
}