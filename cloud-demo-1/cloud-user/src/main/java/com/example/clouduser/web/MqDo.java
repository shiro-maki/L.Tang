package com.example.clouduser.web;

import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class MqDo {
    @Resource
    RabbitTemplate rabbitTemplate;
    @RequestMapping("simpleMsg")
    public String simpleMsg(String msg){
        rabbitTemplate.convertAndSend("simpleQuery",msg);
        return "通过 队列发送简单消息";
    }
    @RabbitListener(queuesToDeclare = @Queue("simpleQuery"))
    public void recvSimpleMsg(String msg){

    }
}
