package com.kq.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * IndexController
 *
 * @author kq
 * @date 2018-12-13
 */
@RestController
public class IndexController {

    @ResponseBody
    @RequestMapping( value = "/index")
    public String register() {
        return "indextest";
    }

}
