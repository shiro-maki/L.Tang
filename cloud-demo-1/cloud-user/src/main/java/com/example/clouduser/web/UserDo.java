package com.example.clouduser.web;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.Path;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class UserDo {
    @RequestMapping("user")
    String index(HttpServletRequest request){
        return "user : " +request.getServerPort();
    }
    @RequestMapping("hello")
    String hello(String name){
        return "hello" +name;
    }

    @RequestMapping("hello")
    Date castDay(@RequestParam("dt") String date) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        return sdf.parse(date);
    }

    @RequestMapping("week/{date}")
    String week(@PathVariable("date") String dateStr) throws ParseException {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyyMMdd");
        Date date=sdf.parse(dateStr);
        sdf=new SimpleDateFormat("eee");
        return sdf.format(date);
    }
}
