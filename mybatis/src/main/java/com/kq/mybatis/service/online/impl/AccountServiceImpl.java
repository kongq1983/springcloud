package com.kq.mybatis.service.online.impl;

import com.kq.mybatis.mapper.online.AccountMapper;
import com.kq.mybatis.service.online.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AccountServiceImpl
 *
 * @author kq
 * @date 2018-11-20
 */
@Service("onlineAccountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<String> getUsers() {
        return accountMapper.getUsers();
    }
}
