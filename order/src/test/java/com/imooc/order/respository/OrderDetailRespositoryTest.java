package com.imooc.order.respository;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;

@Component
public class OrderDetailRespositoryTest extends OrderApplicationTests {
    @Autowired
    private OrderDetailRespository orderDetailRespository;

    @Test
    public void testSave() {
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setCreateTime(new Date());
        orderDetail.setUpdateTime(new Date());
        orderDetail.setDetailId("123456");
        orderDetail.setOrderId("123456");
        orderDetail.setProductIcon("");
        orderDetail.setProductId("10");
        orderDetail.setProductName("aaaa");
        orderDetail.setProductPrice(new BigDecimal(4.5));
        orderDetail.setProductQuantity(3);


        OrderDetail save = orderDetailRespository.save(orderDetail);
        Assert.assertNotNull(save);
    }
}