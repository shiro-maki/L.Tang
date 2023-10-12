package com.example.cloudindex.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "myinfo")
@Data
public class MyInfo {
    String name;
    int age;
    String email;
}
