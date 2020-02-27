package com.imooc.order.client;

import com.imooc.order.entity.ProductInfo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;


@FeignClient(name = "product")
public interface ProductClient {

    @GetMapping("/product/msg")
    String productMsg();

    //
    @GetMapping("/product/listForOrder")
    List<ProductInfo> listForOrder(@RequestBody List<String> productIdlist);
}
