package com.imooc.order.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.imooc.order.service.OrderMasterService;

/**
 * (OrderMaster)表控制层
 *
 * @author makejava
 * @since 2020-02-23 19:03:24
 */
@RestController
@RequestMapping("orderMaster")
public class OrderMasterController {
    /**
     * 服务对象
     */
    @Autowired
    private OrderMasterService orderMasterService;


}