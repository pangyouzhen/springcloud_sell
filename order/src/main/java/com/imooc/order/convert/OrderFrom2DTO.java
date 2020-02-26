package com.imooc.order.convert;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.entity.OrderDetail;
import com.imooc.order.enums.ResultEnum;
import com.imooc.order.exceptions.OrderException;
import com.imooc.order.form.OrderForm;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

@Slf4j
public class OrderFrom2DTO {

    public static OrderDTO convert(OrderForm orderForm) {
        OrderDTO orderDTO = new OrderDTO();
        orderDTO.setBuyerName(orderForm.getName());
        orderDTO.setBuyerPhone(orderForm.getPhone());
        orderDTO.setBuyerAddress(orderForm.getAddress());
        orderDTO.setBuyerOpenid(orderForm.getOpenid());

        List<OrderDetail> orderDetails = new ArrayList<>();
        Gson gson = new Gson();
        try {
            orderDetails = gson.fromJson(orderForm.getItems(), new TypeToken<List<OrderDetail>>() {
            }.getType());
        } catch (Exception e) {
            log.error("convert json error string={}", orderForm.getItems());
            throw new OrderException(ResultEnum.PARAMETER_ERROR);
        }

        orderDTO.setOrderDetails(orderDetails);
        return orderDTO;
    }
}
