package com.consumer;


import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author yzy
 * @description
 * @create 2019-06-27-14:24
 */
@Component
public class TopicRe {

    @RabbitListener(queues = "F")
    public void getM(String str){
        System.out.println("top.message路由的队列F==="+str);
    }

    @RabbitListener(queues = "G")
    public void getMm(String str){
        System.out.println("top.#路由的队列G==="+str);
    }
}
