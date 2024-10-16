package com.peng.listener;
import com.rabbitmq.client.AMQP;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@Component
public class ConsumerListener {

//    @RabbitListener(queues = "direct_queue03")
//    public void consumer01(String msg) {
//        System.out.println("从简单队列中获取了一个消息: " + msg);
//        int res = 1 /0;
//    }

//    @RabbitListener(queues = "direct_queue03")
    public void consumer01(Message msg, Channel channel) {
        long deliveryTag = msg.getMessageProperties().getDeliveryTag();
        System.out.println("从简单队列中获取了一个消息: Id: " + deliveryTag + "内容： " + new String(msg.getBody()) );

        try {
//            channel.basicAck(msg.getMessageProperties().getDeliveryTag(), true);
            channel.basicNack( deliveryTag, true, true);
        } catch (IOException e) {

            throw new RuntimeException(e);
        }

    }

    @RabbitListener(queues = "direct_queue03")
    public void receiver03(String msg) throws InterruptedException {
        System.out.println("消费者接收到消息: " + msg  );
        Thread.sleep(5000 );
//        int res = 3 / 0;

    }


}







