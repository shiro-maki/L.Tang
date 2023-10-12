package com.example.cloud.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoDo {

    @RequestMapping("zl/demo")
    public String demo(){
        return " zuul demo !";
    }

}
