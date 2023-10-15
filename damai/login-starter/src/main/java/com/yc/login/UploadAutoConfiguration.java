package com.yc.login;

import com.yc.login.bean.LoginProperties;
import com.yc.login.web.LoginInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
@ComponentScan("com.yc.login")
@ConditionalOnProperty(prefix = "login", name = "enable")
public class UploadAutoConfiguration implements WebMvcConfigurer {

    @Resource
    LoginProperties loginProperties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        final InterceptorRegistration ir = registry.addInterceptor(new LoginInterceptor());
        for (String resource : loginProperties.getResources()) {
            ir.addPathPatterns(resource);
        }
    }
}
