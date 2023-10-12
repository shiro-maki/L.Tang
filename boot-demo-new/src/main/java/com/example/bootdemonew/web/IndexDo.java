package com.example.bootdemonew.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IndexDo {
    @RequestMapping("/")
    String hello(){
        return "你好，世界";
    }
}
