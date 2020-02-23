package com.imooc.order.respository;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.entity.OrderDetail;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderDetailRespositoryTest {
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