package com.kq.elasticsearch.mapper;

import com.kq.elasticsearch.entity.Inventory;

import java.util.List;

/**
 * InventoryMapper
 *
 * @author1 kq
 * @date 2019-01-17
 */
public interface InventoryMapper {

    /**
     * 获取
     * @return
     */
    public List<Inventory> getInventoryList();

}
