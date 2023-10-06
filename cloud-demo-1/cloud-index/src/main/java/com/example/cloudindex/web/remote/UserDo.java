package com.example.cloudindex.web.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

@FeignClient("cloud-user")
public interface UserDo {
    @RequestMapping("user")
    String user();

    @RequestMapping("hello")
    String hello(String name);

    @RequestMapping("castDate")
    Date casrDate(@RequestParam("dt") String date);

    @RequestMapping("week/{date}")
    String week(@PathVariable("date") String dateStr);


}
