package com.kq.springcloud.printservice.entity;

import java.math.BigDecimal;

/**
 * SaleOrderDetail
 *
 * @author kq
 * @date 2018-11-01
 */
public class SaleOrderDetail {

    /** 商品名称 */
    private String name;
    /** 商品单价 */
    private BigDecimal price;
    /** 商品数量 */
    private Integer num; //商品数量
    /** 小计 */
    private BigDecimal total;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "SaleOrderDetail{" +
                "name='" + name + '\'' +
                ", price=" + price +
                ", num=" + num +
                ", total=" + total +
                '}';
    }
}
