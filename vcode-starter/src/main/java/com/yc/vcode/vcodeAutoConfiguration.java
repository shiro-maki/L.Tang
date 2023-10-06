package com.yc.vcode;


import com.yc.vcode.bean.VcodeProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//TODO 查明为什么继承

import javax.annotation.Resource;

@Configuration
@ComponentScan("com.yc.vcode")
public class vcodeAutoConfiguration {
    @Resource
    VcodeProperties properties;

}
