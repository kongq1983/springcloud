package com.kq.appolloclient.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * AppolloClientController
 *
 * @author kq
 * @date 2018-11-23
 */
@RestController
public class AppolloClientController {



    @GetMapping("/getValue")
    private String getValue(String key){
        return key;
    }


}
