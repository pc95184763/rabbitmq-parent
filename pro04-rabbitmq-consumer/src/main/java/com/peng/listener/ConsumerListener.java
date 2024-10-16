package com.peng.listener;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.UnsupportedEncodingException;

@Component
public class ConsumerListener {

    @RabbitListener(queues = "direct_queue03")
    public void consumer01(String msg) {
        System.out.println("从简单队列中获取了一个消息: " + msg);
        int res = 1 /0;
    }


}




