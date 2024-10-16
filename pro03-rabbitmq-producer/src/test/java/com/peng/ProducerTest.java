package com.peng;

import org.junit.jupiter.api.Test;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageDeliveryMode;
import org.springframework.amqp.core.MessagePostProcessor;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.UUID;

@SpringBootTest
public class ProducerTest {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //演示发送消息成功
    @Test
    public void test01 () {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString() );
        rabbitTemplate.convertAndSend("direct_exchange002" ,"abc"," 这是一条发给交换机的需要确认的消息",correlationData);
    }


    //2演示发送给交换机失败
    @Test
    public void test02 () {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString() );
        rabbitTemplate.convertAndSend("direct_exchange005" ,"abc"," 这是一条发给交换机的需要确认的消息",correlationData);
    }

    //3演示发送给队列失败
    @Test
    public void test03 () {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString() );
        rabbitTemplate.convertAndSend("direct_exchange002" ,"abc"," 这是一条发给交换机的需要确认的消息",correlationData);
    }

    //4
    @Test
    public void test04   () {
        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString() );
        rabbitTemplate.convertAndSend("direct_exchange002", "abc", " 这是一条发给交换机的非持久化消息",
                message -> {
                    message.getMessageProperties().setDeliveryMode(MessageDeliveryMode.NON_PERSISTENT);
                    return message;
                }
                , correlationData);
    }

}





