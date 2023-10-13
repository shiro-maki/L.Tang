package com.yc.damai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "no_com.yc")
public class IndexApp {
    public static void main(String[] args) {
        SpringApplication.run(IndexApp.class, args);
    }
}
