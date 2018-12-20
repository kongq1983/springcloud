package com.kq.jms.rabbitmq.fanout;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * FanoutReceive
 *
 * @author kq
 * @date 2018-12-20
 */

@Component
public class FanoutReceive {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @RabbitListener(queues="fanout.debug")
    public void processDebug(String str) {
        sleep();
        logger.info("fanout.debug:{}",str);

    }

    @RabbitListener(queues="fanout.info")
    public void processInfo(String str) {
        sleep();
        logger.info("fanout.info:{}",str);
    }

    @RabbitListener(queues="fanout.warn")
    public void processWarn(String str) {
        sleep();
        logger.info("fanout.warn:{}",str);
    }

    private void sleep(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
