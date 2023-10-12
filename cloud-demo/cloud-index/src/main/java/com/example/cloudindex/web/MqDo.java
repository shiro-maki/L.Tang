package com.example.cloudindex.web;

import lombok.Data;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
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
        return "通过 simpleQuery 队列发送简单消息: " + msg;
    }

    @RabbitListener(queuesToDeclare = @Queue("simpleQuery"))
    public void recvSimpleMsg(String msg){
        System.out.println("简单消息1: " + msg);
    }

    @RabbitListener(queuesToDeclare = @Queue("simpleQuery"))
    public void recvSimpleMsg1(String msg){
        System.out.println("简单消息2: " + msg);
    }

    //////////////////////////////////////////////////////////////
    @RequestMapping("fanout")
    public String fanout(String msg){
        rabbitTemplate.convertAndSend("fanoutTest", "", msg);
        return "广播消息: " + msg;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("FanoutQueue1"),
            exchange = @Exchange(value = "fanoutTest", type = ExchangeTypes.FANOUT)
    ))
    public void recvFanout(String msg){
        System.out.println("Fanout1 : " + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue("FanoutQueue2"),
            exchange = @Exchange(value = "fanoutTest", type = ExchangeTypes.FANOUT)
    ))
    public void recvFanout1(String msg){
        System.out.println("Fanout2 : " + msg);
    }

    ////////////////////////////////////////////////////////
    @RequestMapping("direct")
    public String direct(String msg, String key){
        rabbitTemplate.convertAndSend("directTest", key, msg);
        return "定向路由: " + msg;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "directTest",
                    type=ExchangeTypes.DIRECT),
                    key = "info"
    ))
    public void recvDirect1(String msg){
        System.out.println("direct1 : " + msg);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "directTest",
                    type=ExchangeTypes.DIRECT),
                    key = {"error","info","debug"}
    ))
    public void recvDirect2(String msg){
        System.out.println("direct2 : " + msg);
    }

    //////////////////////////////////////////////////////////
    @RequestMapping("topic")
    public String topic(Info info, String key){
        rabbitTemplate.convertAndSend("topicTest", key, info);
        return "主题路由模式: " + info;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "topicTest", type = ExchangeTypes.TOPIC),
            key = {"user.#", "order.*"}
    ))
    public void recvTopic1(Info info){
        System.out.println("Topic1 : " + info);
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue,
            exchange = @Exchange(value = "topicTest", type = ExchangeTypes.TOPIC),
            key = {"user.*", "address.#", "demo.insert"}
    ))
    public void recvTopic2(Info info){
        System.out.println("Topic2 : " + info);
    }
}

@Data
class Info implements java.io.Serializable{
    String name;
    int numb;
}


