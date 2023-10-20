package com.yc.damai;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexController {
    @RequestMapping("index")
    public String add(){
        return "这是测试";
    }
}
