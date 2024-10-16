package com.peng.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfiguration {
    // 1
    @Bean
    public RabbitTemplate  rabbitTemplate(ConnectionFactory connectionFactory) {
        RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setConfirmCallback( new RabbitTemplate.ConfirmCallback() {
            @Override
            public void confirm(CorrelationData correlationData, boolean ack, String cause) {
                if ( ack) {
                    System.out.println("消息正常发送给交换机了");
                }
                else {
                    String msgId = correlationData.getId();
                    System.out.println("消息发送给交换机失败了..." + msgId);
                    System.out.println(cause );
                }
            }
        });
        rabbitTemplate.setMandatory(true);

        rabbitTemplate.setReturnsCallback(new RabbitTemplate.ReturnsCallback() {
            @Override
            public void returnedMessage(ReturnedMessage returnedMessage) {
                System.out.println("returnedMessage.getMessage() = " + returnedMessage.getMessage());
                System.out.println("returnedMessage.getExchange() = " + returnedMessage.getExchange() );
                System.out.println("returnedMessage.getReplyText() = " + returnedMessage.getReplyText());
                System.out.println("returnedMessage.getRoutingKey() = " + returnedMessage.getRoutingKey());
                System.out.println("returnedMessage.getReplyCode() = " + returnedMessage.getReplyCode());
            }
        });
        return rabbitTemplate;
    }



    @Bean("direct_exchange002")
    public Exchange exchange002() {
        return ExchangeBuilder.directExchange("direct_exchange002").durable(true).build();
    }


    @Bean
    public Queue queue003() {
        return QueueBuilder.durable("direct_queue03").build();
    }


    @Bean
    public Binding binding() {
        return BindingBuilder.bind( queue003() ).to( exchange002() ).with("abc").noargs();
    }


}




