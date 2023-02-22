package com.example.demo.mq.message;

import com.example.demo.emun.MessageMatchEnum;
import com.example.demo.entity.BaseMQEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.spring.annotation.MessageModel;
import org.apache.rocketmq.spring.annotation.RocketMQMessageListener;
import org.apache.rocketmq.spring.core.RocketMQListener;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * @author ****
 *
 * 消息消费者
 *
 */
@Slf4j
@Component
@RocketMQMessageListener(topic = "all_message_topic",
        consumerGroup = "message_consumer",
        selectorExpression = "*",
        messageModel = MessageModel.BROADCASTING)
public class MessageConsumer implements RocketMQListener<BaseMQEntity> {




    //@Resource
    //List<BeasAdapter> beasAdapters;


    @Override
    public void onMessage(BaseMQEntity object) {

        //BeasAdapter adapter = getAdapter(object);
        //if (Objects.nonNull(adapter)){
        //    adapter.handle();
        //}else {
        //    log.error("adapter is null!! ");
        //}

       // int i = 1/0;
        System.out.println("end");

    }


    /**
     * 获取消息处理的适配器
     * @param object
     * @return
     */
   //public BeasAdapter getAdapter(BaseMQEntity object){
   //    for (BeasAdapter beasAdapter : beasAdapters) {
   //        MessageMatchEnum messageType = MessageMatchEnum.getMessageType(object.getKey());
   //        if (Objects.nonNull(messageType) &&  beasAdapter.match(messageType)){
   //           return beasAdapter;
   //        }
   //    }
   //    return null;
   //}

}
