package com.example.cloudeureka.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestDo {
    @RequestMapping("zl/demo")
    String demo(){
        return " zuul demo !";
    }
}
