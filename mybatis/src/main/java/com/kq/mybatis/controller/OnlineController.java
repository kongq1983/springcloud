package com.kq.mybatis.controller;

import com.github.pagehelper.Page;
import com.kq.mybatis.mapper.online.AccountMapper;
import com.kq.mybatis.mapper.online.UserMapper;
import com.kq.mybatis.service.online.AccountService;
import com.kq.mybatis.service.online.UserService;
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

    @Autowired
    private UserService userService;

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


    @GetMapping("/getPageUsers")
    public Page<String> getPageUsers(){
        return userService.getPageUsers();
    }


    @GetMapping("/getPageUsers1")
    public Page<String> getPageUsers1(){
        return userService.getPageUsers();
    }


    /**
     * 分页 mapper是list
     * @return
     */
    @GetMapping("/getPageUsers2")
    public Page<String> getPageUsers2(){
        return userService.getPageUsers2();
    }

    @GetMapping("/getPageUsers3")
    public List<String> getPageUsers3(){
        return userService.getPageUsers3();
    }


    @GetMapping("/getPageUsers4")
    public List<String> getPageUsers4(){
        return userService.getPageUsers4();
    }

}
