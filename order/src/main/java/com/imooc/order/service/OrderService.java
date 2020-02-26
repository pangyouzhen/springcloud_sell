package com.imooc.order.service;

import com.imooc.order.dto.OrderDTO;
import org.springframework.stereotype.Service;

public interface OrderService {

    OrderDTO create(OrderDTO orderDTO);

}
