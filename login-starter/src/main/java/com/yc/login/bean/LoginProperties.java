package com.yc.login.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "login")
public class LoginProperties
{
    String tableUser;
    String columnName;
    String columnPwd;
    String columnEmail;
    String encryption;
    String userClassName;
}
