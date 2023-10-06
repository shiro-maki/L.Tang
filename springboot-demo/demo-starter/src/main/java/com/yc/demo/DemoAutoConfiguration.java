package com.yc.demo;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.yc.demo")
@ConditionalOnProperty
public class DemoAutoConfiguration {
}
