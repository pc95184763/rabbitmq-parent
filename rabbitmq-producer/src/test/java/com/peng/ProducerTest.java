package com.peng;


import org.junit.jupiter.api.Test;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class ProducerTest {


    @Autowired
    private RabbitTemplate rabbitTemplate;


    @Test
    public void test01() {
        rabbitTemplate.convertAndSend("simple_queue","hello rabbitmq...");
    }

    @Test
    public void test02() {
        for (int i = 0 ; i <10 ;i++) {
            rabbitTemplate.convertAndSend("work_queue", "hello rabbitmq"  + i);
        }
    }

    @Test
    public void test03() {
        rabbitTemplate.convertAndSend("fanout_exchange","","hello fanout exchange....");
    }

    @Test
    public void test04() {
        rabbitTemplate.convertAndSend("direct_exchange","info","hello direct info message...");
        rabbitTemplate.convertAndSend("direct_exchange","error", "hello direct error message");
        rabbitTemplate.convertAndSend("direct_exchange","warning", "hello direct warnning message");
    }

    @Test
    public void test05() {

        rabbitTemplate.convertAndSend("topic_exchange","peng.orange.com", "topic exchange..from queue01");
        rabbitTemplate.convertAndSend("topic_exchange","lazy.error.info","hello topic exchange... from lazy");

    }

    @Test
    public void test06() {
        rabbitTemplate.convertAndSend("fanout_exchange001","","hello fanout from API...");
    }


}



