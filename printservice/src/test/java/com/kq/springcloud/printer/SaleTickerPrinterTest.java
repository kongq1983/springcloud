package com.kq.springcloud.printer;

import com.kq.springcloud.printable.SaleTicket;
import com.kq.springcloud.printservice.entity.SaleOrder;
import com.kq.springcloud.printservice.entity.SaleOrderDetail;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * SaleTickerPrinterTest
 *
 * @author kq
 * @date 2018-11-01
 */
public class SaleTickerPrinterTest {

    public static void main(String[] args) {

        SaleOrder saleOrder = new SaleOrder();
        saleOrder.setTotal(new BigDecimal(100));
        saleOrder.setName("小王");
        saleOrder.setOrderCode("2018110110001");

        List<SaleOrderDetail> details = new ArrayList<>();

        SaleOrderDetail d = new SaleOrderDetail();
        d.setName("红烧鲫鱼");
        d.setNum(2);
        d.setPrice(new BigDecimal((18)));
        d.setTotal(new BigDecimal(36));

        SaleOrderDetail d1 = new SaleOrderDetail();
        d1.setName("酸菜鱼");
        d1.setNum(1);
        d1.setPrice(new BigDecimal((50)));
        d1.setTotal(new BigDecimal(50));


        details.add(d);
        details.add(d1);

        saleOrder.setDetails(details);

        SaleTicket salesTicket = new SaleTicket(saleOrder);
        SaleTickerPrinter p = new SaleTickerPrinter(salesTicket);
        p.printer();

    }

}
