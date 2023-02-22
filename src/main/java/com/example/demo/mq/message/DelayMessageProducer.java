package com.example.demo.mq.message;

import com.example.demo.emun.MessageMatchEnum;

/**
 * @author ***
 */
public class DelayMessageProducer extends BeasAdapter{

    public DelayMessageProducer(){
        super(MessageMatchEnum.DELAY_MESSAGE);
    }
    @Override
    public void handle() {
        System.out.println("延迟消息处理");
    }
}
