package com.yc.vcode.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "vcode")
@Data
public class VcodeProperties {

    List<String> resources;
}
