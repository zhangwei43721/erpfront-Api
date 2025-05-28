package com.example.demo.handler;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.MappedTypes;

import java.util.List;

/**
 * 专门用于处理List<String>类型的JSON类型处理器
 */
@MappedJdbcTypes(JdbcType.VARCHAR)
@MappedTypes({List.class})
public class ListStringJsonTypeHandler extends JsonTypeHandler<List<String>> {

    @SuppressWarnings("unchecked")
    public ListStringJsonTypeHandler() {
        super((Class<List<String>>) (Class<?>) List.class);
    }
}
