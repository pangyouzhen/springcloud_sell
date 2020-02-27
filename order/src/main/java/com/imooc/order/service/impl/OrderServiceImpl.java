package com.imooc.order.service.impl;

import com.imooc.order.client.ProductClient;
import com.imooc.order.dto.CartDTO;
import com.imooc.order.dto.OrderDTO;
import com.imooc.order.entity.OrderDetail;
import com.imooc.order.entity.OrderMaster;
import com.imooc.order.entity.ProductInfo;
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
import java.math.BigInteger;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDetailRespository orderDetailRespository;

    @Autowired
    private OrderMasterRespository orderMasterRespository;

    @Autowired
    private ProductClient productClient;

    @Override
    public OrderDTO create(OrderDTO orderDTO) {
        String orderId = KeyUtils.genUniqueKey();
//    查询商品信息
        List<String> productIdList = orderDTO.getOrderDetails().stream().map(OrderDetail::getProductId).collect(Collectors.toList());
        List<ProductInfo> productInfos = productClient.listForOrder(productIdList);

//        计算总价
        BigDecimal orderAmount = new BigDecimal(BigInteger.ZERO);
        for (OrderDetail orderDetail : orderDTO.getOrderDetails()) {
            for (ProductInfo productInfo : productInfos) {
                if (productInfo.getProductId().equals(orderDetail.getProductId())) {
                    orderAmount = productInfo.getProductPrice().multiply(new BigDecimal(orderDetail.getProductQuantity())).add(orderAmount);
                    BeanUtils.copyProperties(productInfo, orderDetail);
                    orderDetail.setOrderId(orderId);
                    orderDetail.setDetailId(KeyUtils.genUniqueKey());

                    orderDetail.setCreateTime(new Date());
                    orderDetail.setUpdateTime(new Date());

                    orderDetailRespository.save(orderDetail);
                }
            }
        }
//        扣库存
        List<CartDTO> cartDTOS = orderDTO.getOrderDetails().stream().map(e -> new CartDTO(e.getProductId(), e.getProductQuantity())).collect(Collectors.toList());
        productClient.decreasseStock(cartDTOS);
//订单入库
        OrderMaster orderMaster = new OrderMaster();
        orderDTO.setOrderId(orderId);
        BeanUtils.copyProperties(orderDTO, orderMaster);
        orderMaster.setOrderAmount(orderAmount);
        orderMaster.setOrderStatus(OrderStatusEnum.NEW.getCode());
        orderMaster.setPayStatus(PayStatusEnum.NEW.getCode());
        orderMaster.setCreateTime(new Date());
        orderMaster.setUpdateTime(new Date());
        orderMasterRespository.save(orderMaster);
        return orderDTO;
    }
}
