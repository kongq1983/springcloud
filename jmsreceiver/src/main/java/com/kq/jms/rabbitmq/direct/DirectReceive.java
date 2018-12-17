package com.kq.jms.rabbitmq.direct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * DirectSender
 *
 * @author kq
 * @date 2018-12-17
 */

@Component
@RabbitListener(queues = "directQueue")
public class DirectReceive {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;

    @RabbitHandler
    public void receive(String msg){
       logger.info("receive msg:{}",msg);
//        rabbitTemplate.convertAndSend("notify.payment", msg);
    }

}
