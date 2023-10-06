package com.example.cloudorder.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class OrderDo {
    @RequestMapping("order")
    String index(HttpServletRequest request){
        return "order : " +request.getServerPort();
    }
}
