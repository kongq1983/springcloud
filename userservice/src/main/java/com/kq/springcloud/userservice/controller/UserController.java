package com.kq.springcloud.userservice.controller;

/**
 * Created by qikong on 18/10/21.
 */

import com.google.common.collect.Lists;
import com.kq.springcloud.common.vo.ServiceInstanceVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);


    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/user-instance")
    public List<ServiceInstance> showInfo(){
        return this.discoveryClient.getInstances("userservice");
    }


    @GetMapping("/{id}")
    public String findById(@PathVariable Long id) {
        return String.valueOf(id);
    }

    @GetMapping("/service/{serviceId}")
    public List<ServiceInstanceVo> getServiceInstants(@PathVariable("serviceId") String servcieId){

        List<ServiceInstance> list = this.discoveryClient.getInstances(servcieId);

        logger.info("servcie instance list : {}",list);

        List<ServiceInstanceVo> newList = Lists.newArrayList();

        for(ServiceInstance s : list){
            ServiceInstanceVo vo = new ServiceInstanceVo();
            vo.setServiceId(s.getServiceId());
            vo.setHost(s.getHost());
            vo.setPort(s.getPort());
            vo.setUri(s.getUri());
            vo.setSecure(s.isSecure());
            vo.setMetadata(s.getMetadata());
            newList.add(vo);

        }


        return  newList;
    }

}
