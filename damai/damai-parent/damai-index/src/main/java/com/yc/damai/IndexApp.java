package com.yc.damai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = "no_com.yc")

public class IndexApp implements WebMvcConfigurer {
    public static void main(String[] args) {
//        System.setProperty("sun.nio.ch.bugLevel", "info");
        SpringApplication.run(IndexApp.class,args);
    }
}
