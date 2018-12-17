package com.kq.jms.rabbitmq.direct;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * DirectApplication
 *
 * @author kq
 * @date 2018-12-17
 */
@SpringBootApplication
@ComponentScan("com.kq.jms.rabbitmq.direct")
public class ReceiveDirectApplication {

    public static void main(String[] args) {
        SpringApplication.run(ReceiveDirectApplication.class, args);
    }

}
