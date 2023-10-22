package com.yc.damai;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.socket.server.standard.ServerEndpointExporter;

import javax.websocket.server.ServerEndpoint;


@SpringBootApplication
@MapperScan("com.yc.damai.mapper")
public class UserApp implements WebMvcConfigurer {
    public static void main(String[] args) {
        SpringApplication.run(UserApp.class, args);
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/**").addResourceLocations("file:D:\\YC\\github\\L.Tang\\damai\\damai-parent\\damai-user\\src\\main\\resources\\static/")
        .addResourceLocations("file:D:\\YC\\github\\L.Tang\\damai\\login-starter\\src\\main\\resources\\static/");
    }

    @Bean
    public ServerEndpointExporter serverEndpointExporter(){
        return new ServerEndpointExporter();
    }
}
