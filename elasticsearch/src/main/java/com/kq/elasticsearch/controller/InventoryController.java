package com.kq.elasticsearch.controller;

import com.kq.elasticsearch.entity.Inventory;
import com.kq.elasticsearch.mapper.InventoryMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * InventoryController
 *
 * @author kq
 * @date 2019-01-17
 */
@RestController
public class InventoryController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private InventoryMapper inventoryMapper;


    @RequestMapping("/inventory/list")
    public String lists(){

        List<Inventory> list = inventoryMapper.getInventoryList();

        logger.info("list.size={}",list.size());

        logger.info("list={}",list);

        return "ok";
    }



}
