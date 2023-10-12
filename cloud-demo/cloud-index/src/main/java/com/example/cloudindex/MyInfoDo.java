package com.example.cloudindex;

import com.example.cloudindex.bean.MyInfo;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RefreshScope
public class MyInfoDo {

    @Resource
    MyInfo myInfo;

    @RequestMapping("my/info")
    MyInfo myInfo(){
        return myInfo;
    }
}
