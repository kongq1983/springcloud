package com.kq.springcloud.printservice.entity;

import java.math.BigDecimal;
import java.util.List;

/**
 * SaleOrder
 *
 * @author kq
 * @date 2018-11-01
 */
public class SaleOrder {

    /** 订单编号*/
    private String orderCode;
    /** 订单名称*/
    private String name;
    /** 合计 */
    private BigDecimal total; //小计

    private List<SaleOrderDetail> details;

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public List<SaleOrderDetail> getDetails() {
        return details;
    }

    public void setDetails(List<SaleOrderDetail> details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "SaleOrder{" +
                "orderCode='" + orderCode + '\'' +
                ", name='" + name + '\'' +
                ", total=" + total +
                ", details=" + details +
                '}';
    }
}
