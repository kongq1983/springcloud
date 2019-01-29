package com.kq.mybatis.service.online.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.kq.mybatis.mapper.online.UserMapper;
import com.kq.mybatis.service.online.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * UserServiceImpl
 * @author kq
 * @date 2019-01-29
 */
@Service
public class UserServiceImpl implements UserService{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserMapper userMapper;

    public Page<String> getPageUsers() {

        logger.debug("----------------getPageUsers------------------------");

//        PageHelper.startPage(2,1);

        return PageHelper.startPage(2, 1).doSelectPage(()->userMapper.getPageUsers());
//        return  userMapper.getPageUsers();

    }


    public Page<String> getPageUsers1() {

        PageHelper.startPage(2,1);

        return  userMapper.getPageUsers();

    }




}
