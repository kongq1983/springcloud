package com.kq.jms.rabbitmq.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * FanoutSender
 *
 * @author kq
 * @date 2018-12-20
 */
@Component
public class FanoutSender {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AmqpTemplate rabbitTemplate;


    public void sender(String msg){
        logger.info("sender msg:{}",msg);
        //参数2将被忽略
        rabbitTemplate.convertAndSend(FanoutConfig.FANOUT_EXCHANGE, "",msg);

    }

}
