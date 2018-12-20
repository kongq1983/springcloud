package com.kq.jms.rabbitmq.fanout;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * FanoutConfig
 *
 * @author kq
 * @date 2018-12-20
 */
@Configuration
public class FanoutConfig {

    public static final String FANOUT_EXCHANGE = "fanoutExchange";

    @Bean
    public Queue debugQueue() {
        return new Queue("fanout.debug");
    }


    @Bean
    public Queue infoQueue() {
        return new Queue("fanout.info");
    }

    @Bean
    public Queue warnQueye() {
        return new Queue("fanout.warn");
    }

    @Bean
    FanoutExchange fanoutExchange() {
        return new FanoutExchange(FANOUT_EXCHANGE);//配置广播路由器
    }

    @Bean
    Binding bindingExchangeDebug() {
        return BindingBuilder.bind(debugQueue()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeInfo() {
        return BindingBuilder.bind(infoQueue()).to(fanoutExchange());
    }

    @Bean
    Binding bindingExchangeWarn() {
        return BindingBuilder.bind(warnQueye()).to(fanoutExchange());
    }

}
