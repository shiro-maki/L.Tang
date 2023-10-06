package com.yc.mvc.web;

import com.yc.mvc.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

@Controller
@RequestMapping("a/b/c")
public class DemoController {
    @RequestMapping("hello.do")
    public String hello(String name){
        return "hello" +name;
    }
    @RequestMapping("toTaobao")
    public String toTaobao(){
        return "redirect:http://www.taobao.com";
    }
    @RequestMapping("sign")
    @ResponseBody
    public Object sign(@Valid User user , Errors errors){
        if(errors.hasErrors()){
            return errors.getAllErrors();
        }
        else {
            System.out.println("注册成功");
            return "注册成功";
        }
    }
}
