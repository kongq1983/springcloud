package com.kq.mybatis.mapper.online;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * AccountMapper
 *
 * @author1 kq
 * @date 2018-11-20
 */
@Repository("onlineAccountMapper")
public interface AccountMapper {

    /**
     * 得到所有用户账号
     * @return
     */
    public List<String> getUsers();

}
