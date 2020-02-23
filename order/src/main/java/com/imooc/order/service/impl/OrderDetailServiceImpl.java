package com.imooc.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.imooc.order.respository.OrderDetailRespository;
import org.springframework.stereotype.Service;
import com.imooc.order.service.OrderDetailService;

/**
 * (OrderDetail)表服务实现类
 *
 * @author makejava
 * @since 2020-02-23 19:03:15
 */
@Service("orderDetailService")
public class OrderDetailServiceImpl implements OrderDetailService {
    @Autowired
    private OrderDetailRespository orderDetailRespository;

}