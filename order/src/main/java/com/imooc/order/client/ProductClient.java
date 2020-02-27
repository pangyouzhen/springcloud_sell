package com.imooc.order.client;

import com.imooc.order.dto.CartDTO;
import com.imooc.order.entity.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/product/msg")
    String productMsg();

    //
    @PostMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdlist);

    @GetMapping("/product/decreaseStock")
    void decreasseStock(@RequestBody List<CartDTO> cartDTOS);
}
