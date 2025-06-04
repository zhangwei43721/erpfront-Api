package com.example.demo.config;

import com.example.demo.handler.ListStringJsonTypeHandler;
import jakarta.annotation.PostConstruct;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * MyBatis配置类，用于注册自定义的TypeHandler
 */
@Configuration
@MapperScan("com.example.demo.mapper")
public class MyBatisConfig {

    private final SqlSessionFactory sqlSessionFactory;

    public MyBatisConfig(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    /**
     * 初始化时注册自定义的TypeHandler
     */
    @PostConstruct
    public void registerTypeHandlers() {
        sqlSessionFactory.getConfiguration().getTypeHandlerRegistry()
                .register(List.class, JdbcType.VARCHAR, ListStringJsonTypeHandler.class);
    }
}
