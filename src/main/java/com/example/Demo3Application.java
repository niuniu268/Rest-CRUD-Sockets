package com.example;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@SpringBootApplication
@MapperScan("com.example.mapper")
@EnableWebMvc
public class Demo3Application {

    public static void main(String[] args) {
        SpringApplication.run( Demo3Application.class, args );
    }

}
