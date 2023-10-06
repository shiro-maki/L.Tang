package com.example.springbootdemo1;

import com.yc.login.bean.LoginProperties;
import com.yc.upload.bean.UploadProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@SpringBootApplication
//@ComponentScan(basePackages = "com.yc.login.bean")
public class SpringbootDemo1Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo1Application.class, args);
    }

    @Resource
    UploadProperties properties;

    @Resource
    LoginProperties loginProperties;

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        properties.getMappings().forEach( i -> {
            String webPath = "/" + i.getWebPath() + "/**";
            String disPath = "file:" + i.getDiskPath();
            registry.addResourceHandler(webPath)
                    .addResourceLocations(disPath);
        });
    }
}
