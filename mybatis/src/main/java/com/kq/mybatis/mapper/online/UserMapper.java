package com.kq.mybatis.mapper.online;

import com.github.pagehelper.Page;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserMapper
 *
 * @author1 kq
 * @date 2018-11-24
 */
@Repository("onlineUserMapper")
public interface UserMapper {

    /**
     * 得到线上所有用户账号
     * @return
     */
    public List<String> getUsers(); /**

     * 得到线上所有用户账号
     * @return
     */
    public Page<String> getPageUsers();



}
