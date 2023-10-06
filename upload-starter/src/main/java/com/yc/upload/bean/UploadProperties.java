package com.yc.upload.bean;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@ConfigurationProperties(prefix = "upload")
@Data
public class UploadProperties {

    List<UploadMapping> mappings;

    @Data
    public static class UploadMapping{
        String webPath;
        String diskPath;
    }

}


