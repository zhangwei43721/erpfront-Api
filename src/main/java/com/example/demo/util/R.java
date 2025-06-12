package com.example.demo.util;

import java.util.HashMap;
import java.util.Map;

public class R extends HashMap<String, Object> {

    private static final String KEY_CODE = "code";
    private static final String KEY_MESSAGE = "message";

    public static R success(String message) {
        R result = new R();
        result.put(KEY_CODE, 200);
        result.put(KEY_MESSAGE, message);
        return result;
    }

    public static <T> R success(String message, T data) {
        R result = success(message);
        result.put("data", data);
        return result;
    }

    public static R error(int code, String message) {
        R result = new R();
        result.put(KEY_CODE, code);
        result.put(KEY_MESSAGE, message);
        return result;
    }

    // 默认错误
    public static Map<String, Object> error(String message) {
        return error(400, message);
    }

    @Override
    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}