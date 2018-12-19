package com.kq.jms.rabbitmq.topic;

import com.kq.jms.rabbitmq.util.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * TopicSchedule
 *
 * @author kq
 * @date 2018-12-18
 */
@Component
public class TopicSchedule {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CoreSender coreSender;
    @Autowired
    private PaymentSender paymentSender;


    @Scheduled(cron="0/10 * * * * ?")
    public void sendCore(){
        logger.info("start sendCore");
        coreSender.user("user"+ DateUtil.formatDateTime());
        coreSender.userQuery("userQuery"+DateUtil.formatDateTime());
    }

    @Scheduled(cron="0/15 * * * * ?")
    public void sendPayment(){
        logger.info("start sendPayment");
        paymentSender.orderQuery("orderQuery"+DateUtil.formatDateTime());
        paymentSender.order("order"+DateUtil.formatDateTime());
        paymentSender.orderDetailQuery("orderDetailQuery"+DateUtil.formatDateTime());
    }

}
