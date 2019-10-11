package com.provider;


import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yzy
 * @description
 * @create 2019-06-27-14:20
 */
@Component
public class TopicSender {

    @Autowired
    private AmqpTemplate amqpTemplate;

    //发送消息 参数1：交换机名字 参数2：路由键 参数3：要发布的消息
    public void send(){
        amqpTemplate.convertAndSend("topicExchange", "top.message", "hello-rabbit-topic");
    }
}
