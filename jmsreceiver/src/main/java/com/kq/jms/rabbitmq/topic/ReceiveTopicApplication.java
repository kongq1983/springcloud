package com.kq.jms.rabbitmq.topic;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * TopicApplication
 *
 * @author kq
 * @date 2018-12-17
 */

@SpringBootApplication
@ComponentScan("com.kq.jms.rabbitmq.topic")
public class ReceiveTopicApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReceiveTopicApplication.class, args);
    }

}
