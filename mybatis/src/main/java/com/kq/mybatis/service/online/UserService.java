package com.kq.mybatis.service.online;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import java.util.List;

/**
 * UserService
 * @author1 kq
 * @date 2019-01-29
 */
public interface UserService {

    public Page<String> getPageUsers();

    public Page<String> getPageUsers1();

    /**
     * 调用getUsers  返回是list的
     * @return
     */
    public Page<String> getPageUsers2();



    public List<String> getPageUsers3();


    public List<String> getPageUsers4();

}
