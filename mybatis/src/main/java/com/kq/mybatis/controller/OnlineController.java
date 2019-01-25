package com.kq.mybatis.controller;

import com.kq.mybatis.mapper.online.AccountMapper;
import com.kq.mybatis.mapper.online.UserMapper;
import com.kq.mybatis.service.online.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * OnlineController
 *
 * @author kq
 * @date 2018-11-20
 */
@RestController
@RequestMapping("/online")
public class OnlineController {

    @Autowired
    private AccountService accountService;


    @Autowired
    private UserMapper userMapper;

    @Autowired
    private AccountMapper accountMapper;

    @GetMapping("/getAccounts")
    public List<String> getAccounts(){
        return this.accountService.getUsers();
    }

    @GetMapping("/getUsers")
    public List<String> getUsers(){
        return this.userMapper.getUsers();
    }


    @GetMapping("/getUsername")
    public String getUsername(){
        return accountMapper.getUserName("");
    }

}
