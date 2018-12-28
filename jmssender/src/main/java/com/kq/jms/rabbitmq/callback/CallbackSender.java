package com.kq.jms.rabbitmq.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * CallbackSender
 *
 * @author kq
 * @date 2018-12-28
 */

@Component
public class CallbackSender implements RabbitTemplate.ConfirmCallback , RabbitTemplate.ReturnCallback{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private AtomicInteger ato = new AtomicInteger(1);



    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private MyMessagePostProcessor myMessagePostProcessor;


    public void send(String topic, String message) {
        rabbitTemplate.setConfirmCallback(this);
        //消息ID
//        CorrelationData correlationData = new CorrelationData(UUID.randomUUID().toString());
        CorrelationData correlationData = new CorrelationData(ato.getAndIncrement()+"");

        logger.info("sender 消息ID={}",correlationData.getId());

        //用RabbitMQ发送MQTT需将exchange配置为amq.callback.topic
        this.rabbitTemplate.convertAndSend(CallbackConfig.EXCHANGE_NAME, topic, message, myMessagePostProcessor,correlationData);
    }

    public void confirm(CorrelationData correlationData, boolean ack, String cause) {

        logger.info("confirm 消息ID={}",correlationData.getId());

        if (ack) {
            logger.info("消息发送确认成功 消息ID={}",correlationData.getId());
        } else {
            logger.info("消息发送确认失败 消息ID={}",correlationData.getId());
        }
    }


    @Override
    public void returnedMessage(Message message, int replyCode, String replyText, String exchange, String routingKey) {

        String messageStr = new String(message.getBody());
        logger.info("returnedMessage 接收到消息内容={} replyCode={} replyText={}",messageStr,replyCode,replyText);
        logger.info("returnedMessage messageId={} messageContent={}",message.getMessageProperties().getMessageId());
    }
}
