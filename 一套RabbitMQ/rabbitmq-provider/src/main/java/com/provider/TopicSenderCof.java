package com.provider;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * 该类用来注入队列、交换机并较队列和交换机绑定
 */
@Component
public class TopicSenderCof {

    //通过queue1可以获取名为F的队列
    @Bean("queue1")
    public Queue queue(){
        return new Queue("F");
    }

    //通过qqueue2可以获取名为G的队列
    @Bean("queue2")
    public Queue queue2(){
        return new Queue("G");
    }

    //注入一个topic类型的交换机
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    //将queue1表示的队列和交换机通过路由键top.message绑定。即通过top.message可以和该对立匹配
    @Bean
    public Binding binding(@Qualifier("queue1")Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("top.message");
    }

    //将queue2表示的队列和交换机通过路由键top.#绑定。#表示零或多个。
    @Bean
    public Binding binding2(@Qualifier("queue2")Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("top.#"); //*一个 #零个或多个
    }

}
