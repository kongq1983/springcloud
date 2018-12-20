package com.kq.jms.rabbitmq.fanout;

import com.kq.jms.rabbitmq.topic.ReceiveTopicApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * ReveiveFantouApplication
 *
 * @author kq
 * @date 2018-12-20
 */

@SpringBootApplication
@ComponentScan("com.kq.jms.rabbitmq.fanout")
public class ReveiveFantouApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReveiveFantouApplication.class, args);
    }

}
