package com.example.springbootdemo1.bean;

import lombok.Data;
import org.springframework.util.DigestUtils;

@Data
public class User {

    Integer uid;
    String username;
    String password;
    String name;
    String email;
    String phone;
    // TODO 其他字段自行扩展

    public static void main(String[] args) {
        String s = DigestUtils.md5DigestAsHex("wa".getBytes());
        System.out.println(s);
        s = DigestUtils.md5DigestAsHex("wa".getBytes());
        System.out.println(s);
        s = DigestUtils.md5DigestAsHex("za".getBytes());
        System.out.println(s);
    }
}
