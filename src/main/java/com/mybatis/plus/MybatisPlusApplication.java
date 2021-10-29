package com.mybatis.plus;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @Classname MybatisPlusApplication
 * @Description TODO
 * @Date 2021/10/28 14:25
 * @Created by 侯凡
 */
@SpringBootApplication
@MapperScan("com.mybatis.plus.mapper")
public class MybatisPlusApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusApplication.class, args);
    }
}
