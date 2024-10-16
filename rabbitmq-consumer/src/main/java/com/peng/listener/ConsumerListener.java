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

    @RabbitListener(queues= "simple_queue")
    public void consumer01(String msg) {
        System.out.println("从简单队列中获取了一个消息: " + msg);
    }

    @RabbitListener(queues = "work_queue")
    public void consumer02( String msg) {
        System.out.println("consumer02 从工作队列中获取了消息: "+ msg);
    }

    @RabbitListener(queues = "work_queue")
    public void consumer03(String msg) {
        System.out.println("consumer03 从工作队列中获取了消息: "+ msg);
    }

    @RabbitListener( queues="fanout_queue01")
    public void consumer04(String msg) {
        System.out.println("consumer04 从工作队列中获取了消息: "+ msg);
    }

    @RabbitListener(queues="fanout_queue02")
    public void consumer05(String msg) {
        System.out.println("consumer05 从工作队列中获取了消息: " + msg);
    }


    @RabbitListener(queues = "direct_queue01")
    public void consumer06(String msg) {
        System.out.println("Consumer06 从direct_queue01 中获取: " + msg);
    }

    @RabbitListener(queues = "direct_queue02")
    public void consumer07(String msg) {
        System.out.println("Consumer07 从direct_queue02 中获取: "+ msg);
    }

    @RabbitListener(queues= "topic_queue01")
    public void consumer08(String msg) {
        System.out.println("consumer08 从 queue01 获取+ "+ msg);
    }

    @RabbitListener(queues = "topic_queue02")
    public void consumer09(String msg){
        System.out.println("consumer09 从queue02 获取+ " + msg);
    }

    @RabbitListener(queues = "fanout_queue008")
    public void consumer10(String msg) {
        System.out.println("consumer10 fanout_exchange001 获取+ " + msg);
    }

    @RabbitListener(bindings = {
        @QueueBinding(
                value = @Queue(name = "direct004", durable = "true"),
                exchange = @Exchange(value = "direct_exchange001", type="direct" ),
                key = {"info","warning"}
        )
    })
    public void consumer11(Message msg) {
        byte[] bytes = msg.getBody();
        try {
            String content = new String(bytes, "UTF-8");
            System.out.println("从q008接受到的消息" + content);
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
    }

}




