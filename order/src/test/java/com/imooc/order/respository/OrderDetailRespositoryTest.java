package com.imooc.order.respository;

import com.imooc.order.OrderApplicationTests;
import com.imooc.order.entity.OrderMaster;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class OrderDetailRespositoryTest extends OrderApplicationTests {
    @Autowired
    private OrderDetailRespository orderDetailRespository;

//    @Test
//    public void testSave()  {
//        OrderMaster orderMaster = new OrderMaster();
//        orderMaster.setBuyerAddress("慕课网");
//        orderMaster.setBuyerName("pyz");
//        orderMaster.setBuyerOpenid("123456");
//        orderMaster.setBuyerPhone("123456");
//        orderMaster.setOrderAmount(new BigDecimal(2.5));
//        orderMaster.setOrderId("123456");
//        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
//        orderMaster.setPayStatus(PayStatusEnum.NEW.getCode());
//
//        OrderMaster orderMaster1 = orderDetailRespository.save(orderMaster);
//        Assert.assertTrue(orderMaster1 != null);
//    }
}