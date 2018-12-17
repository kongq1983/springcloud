package com.kq.jms.rabbitmq.topic;

import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.core.Binding;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * TopicConfig
 *
 * @author kq
 * @date 2018-12-17
 */
@Configuration
public class TopicConfig {
    @Bean
    public Queue coreQueue() {
        return new Queue("topic.core");
    }

    @Bean
    public Queue paymentQueue() {
        return new Queue("topic.payment");
    }

    @Bean
    public TopicExchange coreExchange() {
        return new TopicExchange("coreExchange");
    }

    @Bean
    public TopicExchange paymentExchange() {
        return new TopicExchange("paymentExchange");
    }

    /**
     * 所谓绑定就是将一个特定的 Exchange 和一个特定的 Queue 绑定起来
     * Exchange 和Queue的绑定可以是多对多的关系
     * *匹配1个单词
     * @param coreQueue
     * @param coreExchange
     * @return
     */
    @Bean
    public Binding bindingCoreExchange(Queue coreQueue, TopicExchange coreExchange) {
        return BindingBuilder.bind(coreQueue).to(coreExchange).with("topic.core.*");
    }

    /**
     * #匹配0到多个单词
     * @param paymentQueue
     * @param paymentExchange
     * @return
     */
    @Bean
    public Binding bindingPaymentExchange(Queue paymentQueue, TopicExchange paymentExchange) {
        return BindingBuilder.bind(paymentQueue).to(paymentExchange).with("topic.payment.#");
    }
}
