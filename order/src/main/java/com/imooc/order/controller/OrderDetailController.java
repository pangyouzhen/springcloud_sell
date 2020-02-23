package com.imooc.order.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.imooc.order.service.OrderDetailService;

/**
 * (OrderDetail)表控制层
 *
 * @author makejava
 * @since 2020-02-23 19:03:16
 */
@RestController
@RequestMapping("orderDetail")
public class OrderDetailController {
    /**
     * 服务对象
     */
    @Autowired
    private OrderDetailService orderDetailService;

}