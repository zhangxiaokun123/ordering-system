package com.ly.orderingsystem;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.ly.orderingsystem.mapper")
@SpringBootApplication
public class OrderingSystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(OrderingSystemApplication.class, args);
    }

}
