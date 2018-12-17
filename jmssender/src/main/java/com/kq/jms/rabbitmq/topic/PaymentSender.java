package com.kq.jms.rabbitmq.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * PaymentSender
 *
 * @author kq
 * @date 2018-12-17
 */

@Component
public class PaymentSender {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void order(String msg){
        logger.info("topic.payment.order send message: "+msg);
        rabbitTemplate.convertAndSend("paymentExchange", "topic.payment.order", msg);
    }

    public void orderQuery(String msg){
        logger.info("topic.payment.order.query send message: "+msg);
        rabbitTemplate.convertAndSend("paymentExchange", "topic.payment.order.query", msg);
    }

    public void orderDetailQuery(String msg){
        logger.info("topic.payment.order.detail.query send message: "+msg);
        rabbitTemplate.convertAndSend("paymentExchange", "topic.payment.order.detail.query", msg);
    }
}
