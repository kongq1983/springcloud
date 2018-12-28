package com.kq.jms.rabbitmq.callback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.AmqpException;
import org.springframework.amqp.core.CorrelationAwareMessagePostProcessor;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.support.CorrelationData;
import org.springframework.amqp.support.Correlation;
import org.springframework.stereotype.Component;

/**
 * MyMessagePostProcessor
 *
 * @author kq
 * @date 2018-12-28
 */
@Component
public class MyMessagePostProcessor implements CorrelationAwareMessagePostProcessor {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public Message postProcessMessage(Message message, Correlation correlation) {

        logger.info("postProcessMessage  message={} correlation={}",message,correlation);

        if(correlation!=null){
            if(correlation instanceof  CorrelationData) {
                CorrelationData correlationData = (CorrelationData) correlation;
                MessageProperties messageProperties = message.getMessageProperties();
                if(messageProperties!=null){
                    messageProperties.setMessageId(correlationData.getId());
                    messageProperties.setCorrelationIdString(correlationData.getId());
                }
            }
        }

        return message;
    }

    @Override
    public Message postProcessMessage(Message message) throws AmqpException {
        logger.info("postProcessMessage ----------------");
        return message;
    }
}
