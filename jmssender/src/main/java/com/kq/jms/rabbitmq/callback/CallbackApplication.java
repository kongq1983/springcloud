package com.kq.jms.rabbitmq.callback;

import com.kq.jms.rabbitmq.direct.DirectApplication;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * CallbackApplication
 *
 * @author kq
 * @date 2018-12-28
 */

@SpringBootApplication
@ComponentScan("com.kq.jms.rabbitmq.callback")
public class CallbackApplication {

    public static void main(String[] args) {
        SpringApplication.run(CallbackApplication.class, args);
    }
}
