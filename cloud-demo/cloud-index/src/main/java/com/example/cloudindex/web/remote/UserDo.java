package com.example.cloudindex.web.remote;

import com.example.cloudindex.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;

//默认情况下, 一个远程服务定义一个接口
@FeignClient(value = "cloud-user", fallback = UserDoImpl.class)
public interface UserDo {

    @RequestMapping("user")
    String user();

    @RequestMapping("hello")
    String hello(@RequestParam String name);

    @RequestMapping("castDay")
    Date castDate(@RequestParam("dt") String date);

    @RequestMapping("week/{date}")
    String week(@PathVariable("date") String dateStr);

    @RequestMapping("myinfo")
    User myinfo(User user);

    @RequestMapping("myinfo1")
    User myinfo1(@RequestBody User user);

    @RequestMapping("myinfo2")
    User myinfo2(@RequestBody User user,
                 @RequestParam String newName);

    @RequestMapping("myinfo3")
    User myinfo3(@RequestBody User user,
                 @RequestParam String newName,
                 @RequestParam String newAge);

}
