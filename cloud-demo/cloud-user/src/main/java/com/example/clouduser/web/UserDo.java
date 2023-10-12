package com.example.clouduser.web;

import com.example.clouduser.User;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UserDo {

    @RequestMapping("user")
    String user(HttpServletRequest request){
        return "user : " + request.getServerPort();
    }

    @RequestMapping("hello")
    String hello(String name){
        return "hello " + name;
    }

    @RequestMapping("castDay")
    Date castDay(@RequestParam("dt") String date) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        return sdf.parse(date);
    }

    @RequestMapping("week/{date}")
    String week(@PathVariable("date") String dateStr) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        Date date =  sdf.parse(dateStr);
        sdf = new SimpleDateFormat("EEE");
        return sdf.format(date);
    }

    @RequestMapping("myinfo")
    User myinfo(User user){
        user.setName(user.getName() + " OK!");
        return user;
    }

    @RequestMapping("myinfo1")
    User myinfo1(@RequestBody User user){
        user.setName(user.getName() + " OK!");
        return user;
    }

    @RequestMapping("myinfo2")
    User myinfo2(@RequestBody User user, String newName){
        user.setName(newName);
        return user;
    }

    @RequestMapping("myinfo3")
    User myinfo3(@RequestBody User user,
                 String newName,
                 int newAge){
        user.setName(newName);
        user.setAge(newAge);
        return user;
    }

    // 如果传递多个对象, 那么要将其封装成一个对象
//    @RequestMapping("test")
//    User test(@RequestBody User user,
//                 Order order){
//
//    }

    //  扩展: 请定义订单对象, 和用户对象同时传递过来

}
