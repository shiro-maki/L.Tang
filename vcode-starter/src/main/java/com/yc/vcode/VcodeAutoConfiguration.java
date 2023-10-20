package com.yc.vcode;

import com.yc.vcode.bean.VcodeProperties;
import com.yc.vcode.web.VcodeInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.annotation.Resource;

@Configuration
@ComponentScan("com.yc.vcode")
@ConditionalOnProperty(prefix = "vcode", value = "enable")
public class VcodeAutoConfiguration implements WebMvcConfigurer {

    @Resource
    VcodeProperties properties;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        final InterceptorRegistration ir =
                registry.addInterceptor(new VcodeInterceptor());
        for (String resource : properties.getResources()) {
            ir.addPathPatterns(resource);
        }
    }
}
