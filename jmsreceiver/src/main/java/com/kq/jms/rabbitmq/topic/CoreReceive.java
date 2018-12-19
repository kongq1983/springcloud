package com.kq.jms.rabbitmq.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * TopicReceive
 *
 * @author kq
 * @date 2018-12-18
 */
@Component
public class CoreReceive {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitListener(queues="topic.core")    //监听器监听指定的Queue
    public void coreReceive(String str) {
        logger.info("user receive message:{}",str);
    }

    @RabbitListener(queues="topic.payment")    //监听器监听指定的Queue
    public void paymentReceive(String str) {
        logger.info("payment receive messages:{}",str);
    }

}
