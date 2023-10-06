package com.example.springbootdemo;

import com.example.springbootdemo.web.MailAction;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

@SpringBootTest
class SpringbootDemoApplicationTests {

    @Resource
    MailAction mailAction;

    @Test
    void contextLoads() {
        mailAction.sendSimpleMail("2056760422@qq.com", "测试邮件", "源城公司测试邮件，请勿删除");
    }

}
