package com.example.demo.mq;

import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

//消费者
@Service
//selectorExpression SelectorType.SQL92 sql过滤
//MessageModel.BROADCASTING更改消费者模式为广播
@RocketMQMessageListener(topic = "topic9",
        consumerGroup = "group2",
        selectorExpression = "*",
        messageModel = MessageModel.BROADCASTING)
public class ConsumerV2 implements RocketMQListener<String> {

    //业务逻辑.

    @Override
    public void onMessage(String user) {


        System.out.println(user);

    }
}
