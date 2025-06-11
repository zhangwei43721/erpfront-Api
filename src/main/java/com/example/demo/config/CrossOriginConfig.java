package com.example.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CrossOriginConfig implements WebMvcConfigurer {

    // 2. 使用 @Value 注解读取配置文件中的值
    //    "${cors.allowed-origins}" 中的名字必须和 application.properties 文件中的 key 完全一样
    //    Spring会自动将逗号分隔的字符串转换成 String 数组
    @Value("${cors.allowed-origins}")
    private String[] allowedOrigins;

    /*重写配置方法*/
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                // 3. 使用注入的变量，而不是写死的字符串
                .allowedOrigins(allowedOrigins)
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedHeaders("*")
                .exposedHeaders("X-Custom-Header")
                .allowCredentials(true);
    }
}
