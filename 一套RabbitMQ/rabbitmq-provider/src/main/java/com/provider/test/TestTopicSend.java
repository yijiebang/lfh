package com.provider.test;

import com.provider.Application;
import com.provider.TopicSender;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @author yzy
 * @description
 * @create 2019-06-27-14:22
 */
@SpringBootTest(classes = Application.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class TestTopicSend {

    @Autowired
    private TopicSender topicSender;

    @Test
    public void send(){
        topicSender.send();
    }
}
