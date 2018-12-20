package com.kq.jms.rabbitmq.fanout;

import com.kq.jms.rabbitmq.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * FanoutSchedule
 *
 * @author kq
 * @date 2018-12-20
 */

@Component
public class FanoutSchedule {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    FanoutSender fanoutSender;


    @Scheduled(cron="0/10 * * * * ?")
    public void sendFanout(){
        logger.info("start sendFanout Queue");
        fanoutSender.sender("fanout"+DateUtil.formatDateTime());
    }

}
