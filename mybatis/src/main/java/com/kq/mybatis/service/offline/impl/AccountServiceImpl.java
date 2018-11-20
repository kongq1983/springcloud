package com.kq.mybatis.service.offline.impl;

import com.kq.mybatis.mapper.offline.AccountMapper;
import com.kq.mybatis.service.offline.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * AccountServiceImpl
 *
 * @author kq
 * @date 2018-11-20
 */
@Service("offlineAccountService")
public class AccountServiceImpl implements AccountService{

    @Autowired
    private AccountMapper accountMapper;

    @Override
    public List<String> getUsers() {
        return accountMapper.getUsers();
    }
}
