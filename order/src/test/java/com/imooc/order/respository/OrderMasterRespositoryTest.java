package com.imooc.order.respository;

import com.imooc.order.OrderApplication;
import com.imooc.order.OrderApplicationTests;
import com.imooc.order.entity.OrderMaster;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;

@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMasterRespositoryTest  {

    @Autowired
    private OrderMasterRespository orderMasterRespository;

    @Test
    public void testSave()  {
        OrderMaster orderMaster = new OrderMaster();
        orderMaster.setBuyerAddress("慕课网");
        orderMaster.setBuyerName("pyz");
        orderMaster.setBuyerOpenid("123456");
        orderMaster.setBuyerPhone("123456");
        orderMaster.setOrderAmount(new BigDecimal(2.5));
        orderMaster.setOrderId("123456");
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.NEW.getCode());

        OrderMaster save = orderMasterRespository.save(orderMaster);
        Assert.assertNotNull(save);
    }
}