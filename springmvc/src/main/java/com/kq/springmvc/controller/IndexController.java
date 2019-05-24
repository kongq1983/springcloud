package com.kq.springmvc.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;

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

    @ResponseBody
    @RequestMapping( value = "/getIp")
    public String getLocalhostIp(){
        InetAddress ia=null;
        try {
            ia=ia.getLocalHost();

            String localname=ia.getHostName();
            String localip=ia.getHostAddress();
            System.out.println("本机名称是："+ localname);
            System.out.println("本机的ip是 ："+localip);

            return "localIp="+localip;

        } catch (Exception e) {
            e.printStackTrace();

            return "error="+e.getMessage();
        }
    }




}
