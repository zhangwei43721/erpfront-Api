package com.example.demo.config;

import com.example.demo.handler.ListStringJsonTypeHandler;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.type.JdbcType;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import java.util.List;

/**
 * MyBatis配置类，用于注册自定义的TypeHandler
 */
@Configuration
@MapperScan("com.example.demo.mapper")
public class MyBatisConfig {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 初始化时注册自定义的TypeHandler
     */
    @PostConstruct
    public void registerTypeHandlers() {
        sqlSessionFactory.getConfiguration().getTypeHandlerRegistry()
            .register(List.class, JdbcType.VARCHAR, ListStringJsonTypeHandler.class);
    }
}
