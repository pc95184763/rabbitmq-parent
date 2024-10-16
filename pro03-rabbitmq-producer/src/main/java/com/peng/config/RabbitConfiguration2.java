package com.peng.config;



import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
//public class RabbitConfiguration2 {
//    @Bean
//    public Exchange exchange() {
//        return ExchangeBuilder.directExchange("ex007").durable(true).build();
//    }
//    @Bean
//    public Queue queue() {
//        return QueueBuilder.durable("q100").maxLength(3)
//                .deadLetterExchange("dead_ex001")
//                .deadLetterRoutingKey("dead")
//                .build();
//    }
//    @Bean
//    public Binding bingding() {
//        return BindingBuilder.bind( queue() ).to( exchange() ).with("hello").noargs();
//    }
//
//
//    @Bean
//    public Exchange deadExchange() {
//        return ExchangeBuilder.directExchange("dead_ex001").durable(true).build();
//    }
//
//    @Bean
//    public Queue deadQueue() {
//        return QueueBuilder.durable("dead_q001").build();
//    }

//    @Bean
//    public Binding deadQueueBinding() {
//        return BindingBuilder.bind(deadQueue()).to(deadExchange()).with("dead").noargs();
//    }
//
//}
