package com.kq.mybatis.service.online;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

/**
 * UserService
 * @author1 kq
 * @date 2019-01-29
 */
public interface UserService {

    public Page<String> getPageUsers();

    public Page<String> getPageUsers1();

}
