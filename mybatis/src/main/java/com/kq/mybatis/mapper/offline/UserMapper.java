package com.kq.mybatis.mapper.offline;

import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * UserMapper
 *
 * @author1 kq
 * @date 2018-11-24
 */
@Repository("offlineUserMapper")
public interface UserMapper {

    /**
     * 得到所有用户账号
     * @return
     */
    public List<String> getUsers();

}
