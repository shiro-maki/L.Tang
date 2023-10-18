package com.yc.damai;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(scanBasePackages = "com.yc.damai.web", exclude = DataSourceAutoConfiguration.class)
@EnableFeignClients
public class IndexApp implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(IndexApp.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        registry.addResourceHandler("/**").addResourceLocations("file:E:\\tl\\L.Tang\\damai\\damai-parent\\damai-index\\src\\main\\resources\\static/");
    }
}