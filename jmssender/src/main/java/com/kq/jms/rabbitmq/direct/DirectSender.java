package com.kq.jms.rabbitmq.direct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * DirectSender
 *
 * @author kq
 * @date 2018-12-17
 */

@Component
public class DirectSender {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;


    public void sender(String msg){
       logger.info("sender msg:{}",msg);
        rabbitTemplate.convertAndSend("directQueue", msg);

//        rabbitTemplate.convertAndSend(msg);

    }

}
