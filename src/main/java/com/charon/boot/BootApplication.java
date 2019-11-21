package com.charon.boot;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

//声明该类是一个springBoot的引导类
@SpringBootApplication
@EnableAsync
//@MapperScan(basePackages = {"com.charon.boot.mapper"})
public class BootApplication {

    public static void main(String[] args) {
        SpringApplication.run(BootApplication.class, args);
    }
}
