package com.peng.config;


import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfiguration {
    // 1
    @Bean("fanout_exchange001")
    public Exchange exchange004() {
        return ExchangeBuilder.fanoutExchange("fanout_exchange001").build();
    }

    @Bean
    public Queue queue001() {
        return QueueBuilder.durable("fanout_queue008").build();
    }

    @Bean
    public Queue queue002() {
        return QueueBuilder.durable("fanout_queue009").build();
    }

    @Bean
    public Binding binding() {
        return BindingBuilder.bind( queue001() ).to( exchange004() ).with("").noargs();
    }

}
