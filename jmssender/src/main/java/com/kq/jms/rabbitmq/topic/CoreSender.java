package com.kq.jms.rabbitmq.topic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * CoreSender
 *
 * @author kq
 * @date 2018-12-17
 */
@Component
public class CoreSender {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void user(String msg){
        logger.info("topic.core.user send message: {}",msg);
        rabbitTemplate.convertAndSend("coreExchange", "topic.core.user", msg);
    }

    public void userQuery(String msg){
        logger.info("topic.core.user.query send message: {}",msg);
        rabbitTemplate.convertAndSend("coreExchange", "topic.core.user.query", msg);
    }
}
