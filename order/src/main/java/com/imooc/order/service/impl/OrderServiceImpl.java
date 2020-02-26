package com.imooc.order.service.impl;

import com.imooc.order.dto.OrderDTO;
import com.imooc.order.entity.OrderMaster;
import com.imooc.order.enums.OrderStatusEnum;
import com.imooc.order.enums.PayStatusEnum;
import com.imooc.order.respository.OrderDetailRespository;
import com.imooc.order.respository.OrderMasterRespository;
import com.imooc.order.service.OrderService;
import com.imooc.order.utils.KeyUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRespository orderDetailRespository;

    @Autowired
    private OrderMasterRespository orderMasterRespository;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(KeyUtils.genUniqueKey());
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(new BigDecimal(5));
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.NEW.getCode());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());
        orderMasterRespository.save(orderMaster);
        return null;
    }
}
