package com.imooc.order.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import com.imooc.order.respository.OrderMasterRespository;
import org.springframework.stereotype.Service;
import com.imooc.order.service.OrderMasterService;

/**
 * (OrderMaster)表服务实现类
 *
 * @author makejava
 * @since 2020-02-23 19:03:24
 */
@Service("orderMasterService")
public class OrderMasterServiceImpl implements OrderMasterService {
    @Autowired
    private OrderMasterRespository orderMasterRespository;

}