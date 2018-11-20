package com.kq.mybatis.controller;

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

    @GetMapping("/getUsers")
    public List<String> getUsers(){
        return this.accountService.getUsers();
    }

}
