package com.example.demo.mq.message;


import com.example.demo.emun.MessageMatchEnum;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

/**
 * 抽象逻辑
 *
 */
public abstract class BeasAdapter {

    private MessageMatchEnum matchEnum ;


    public BeasAdapter(MessageMatchEnum type) {
        this.matchEnum= type;
    }

    /**
     * 使用final修饰方法 防止被重写覆盖
     * @param matchEnum
     * @return
     */
    public final Boolean match(MessageMatchEnum matchEnum){
        return matchEnum == this.matchEnum;
    };

    /**
     * 具体处理逻辑
     */
    public  abstract void handle();

}
