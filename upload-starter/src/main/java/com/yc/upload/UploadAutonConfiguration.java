package com.yc.upload;

import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan("com.yc.upload")
@ConditionalOnProperty(prefix = "upload",name="enable")
public class UploadAutonConfiguration {
//    com.yc.upload.UploadAutoConfiguration a;
}
