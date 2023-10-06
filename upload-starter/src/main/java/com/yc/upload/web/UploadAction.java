package com.yc.upload.web;

import com.yc.upload.bean.Result;
import com.yc.upload.bean.UploadProperties;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

@RestController
@RequestMapping("upload")
public class UploadAction {
    @Resource
    UploadProperties properties;
    @GetMapping("props")
    UploadProperties properties(){
        return properties;
    }

    @PostMapping("one/{webPath}")
    Result uploadOne(@PathVariable String webPath , @RequestParam("file")MultipartFile file) throws IOException {
        String diskPath=null;
        for (UploadProperties.UploadMapping mapping : properties.getMappings()) {
            if(mapping.getWebPath().equals(webPath)){
                diskPath =mapping.getDiskPath();
            }
        }
        if(diskPath==null){
            return new Result(0, "上传路径cup五", null);
        }else {
            File dir=new File(diskPath);
            if(dir.exists()==false){
                dir.mkdirs();
            }
        }
        String filename = file.getOriginalFilename();
       String suffix=filename.replaceAll(".+(\\.\\w+)", "$1");
        filename=UUID.randomUUID().toString()+suffix;
        String filepath=diskPath+filename;
        file.transferTo(new File(filepath));
        webPath+="/"+filename;
        return new Result(1, "文件上传成功", webPath);
    }
}
