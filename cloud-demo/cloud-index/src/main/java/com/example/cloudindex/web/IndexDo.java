package com.example.cloudindex.web;

import com.example.cloudindex.User;
import com.example.cloudindex.web.remote.UserDo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.web.bind.annotation.CookieValue;
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
        return "index : " + request.getServerPort();
    }

    @Resource
    RestTemplate restTemplate;

    @RequestMapping("user")
    @HystrixCommand(fallbackMethod = "myUser")
    String user(){
        final String res = restTemplate.getForObject("http://cloud-user/user", String.class);
        return res;
    }

    String myUser(){
        return "RestTemplate 降级方法 myUser";
    }

    @Resource
    UserDo userDo;

    @GetMapping("userByFeign")
    String userByFeign(){
        return userDo.user();
    }

    @RequestMapping("order")
    String order(){
        final String res = restTemplate.getForObject("http://127.0.0.1:8001/order", String.class);
        return res;
    }


    ///////////////////////////////////////////////////
    @RequestMapping("hello")
    String hello(String name){
        return userDo.hello(name);
    }

    @RequestMapping("castDay")
    String castDate(String dt){
        Date d = userDo.castDate(dt);
        return new SimpleDateFormat("yy年MM月dd日").format(d);
    }

    @RequestMapping("week")
    String week(String dt){
        return userDo.week(dt);
    }

    @RequestMapping("myinfo")
    User myinfo(User user){
        return userDo.myinfo(user);
    }

    @RequestMapping("myinfo1")
    User myinfo1(User user){
        return userDo.myinfo1(user);
    }

    @RequestMapping("myinfo2")
    User myinfo1(User user, String newName){
        return userDo.myinfo2(user,newName);
    }

    @RequestMapping("myinfo3")
    User myinfo1(User user, String newName, String newAge){
        return userDo.myinfo3(user,newName, newAge);
    }


    @RequestMapping("cookie")
    String cookie(@CookieValue(required = false) String name){
        return name;
    }







}
