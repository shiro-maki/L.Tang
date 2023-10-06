package com.yc.login;

import com.yc.login.bean.LoginProperties;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
@ComponentScan("com.yc.login")
@ConditionalOnProperty(prefix = "login",name="enable")
public class loginAutoConfiguration implements WebMvcConfigurer {
    @Resource
    LoginProperties properties;
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        final Inte
//        for(String resource : properties.getRe){
//            ir.addP
//        }
//    }
}
