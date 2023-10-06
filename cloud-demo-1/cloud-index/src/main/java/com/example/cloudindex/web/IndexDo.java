package com.example.cloudindex.web;

import com.example.cloudindex.web.remote.UserDo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class IndexDo {
    @RequestMapping("index")
    String index(HttpServletRequest request){
        return "index : " +request.getServerPort();
    }

    @Resource
    RestTemplate restTemplate;
    @RequestMapping("user")
    String user(){
        final String res = restTemplate.getForObject("http://cloud-user/user", String.class);
        return res;
    }

    @RequestMapping("order")
    String order(){
        final String res = restTemplate.getForObject("http://127.0.0.1:8001/order", String.class);
        return res;
    }
    @Resource
    UserDo userDo;
    @GetMapping("userByFeign")
    String userByFeign(){
        return userDo.user();
    }

    @RequestMapping("hello")
    String hello(String name){
        return userDo.hello(name);
    }

    @RequestMapping("castDay")
    String castDate(String dt){
        Date d=userDo.casrDate(dt);
        return new SimpleDateFormat("yy年MM月dd日").format(d);
    }

    @RequestMapping("week")
    String week(String dt){
        return userDo.week(dt);
    }


}
