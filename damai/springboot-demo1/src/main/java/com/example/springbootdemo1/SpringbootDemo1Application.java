package com.example.springbootdemo1;

//import com.yc.upload.bean.UploadProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@SpringBootApplication
public class SpringbootDemo1Application implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo1Application.class, args);
    }

}
