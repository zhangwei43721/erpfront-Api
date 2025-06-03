package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;

public class R {

    private static final String KEY_CODE = "code";
    private static final String KEY_MESSAGE = "message";

    public static Map<String, Object> success(String message) {
        Map<String, Object> result = new HashMap<>();
        result.put(KEY_CODE, 200);
        result.put(KEY_MESSAGE, message);
        return result;
    }

    public static <T> Map<String, Object> success(String message, T data) {
        Map<String, Object> result = success(message);
        result.put("data", data);
        return result;
    }

    public static Map<String, Object> error(int code, String message) {
        Map<String, Object> result = new HashMap<>();
        result.put(KEY_CODE, code);
        result.put(KEY_MESSAGE, message);
        return result;
    }

    // 默认错误
    public static Map<String, Object> error(String message) {
        return error(400, message);
    }
}