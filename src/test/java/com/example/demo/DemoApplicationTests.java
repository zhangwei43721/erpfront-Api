package com.example.demo;

import org.junit.jupiter.api.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@MapperScan("com.example.demo.mapper")//添加这句话
class DemoApplicationTests {

    @Test
    void contextLoads() {
    }

}
