package com.kq.ratelimiter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * RateLimiterApplication
 * @author kq
 * @date 2018-12-18
 */
@SpringBootApplication
@ServletComponentScan
public class RateLimiterApplication {

    public static void main(String[] args){
        SpringApplication.run(RateLimiterApplication.class, args);
    }

}
