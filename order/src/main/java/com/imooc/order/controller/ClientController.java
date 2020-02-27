package com.imooc.order.controller;


import com.imooc.order.client.ProductClient;
import com.imooc.order.entity.ProductInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@Slf4j
public class ClientController {
    @Autowired
    ProductClient productClient;

    @GetMapping("/getProductMsg")
    public String getProductMsg() {
        String response = productClient.productMsg();
        log.info("response={}", response);
        return response;
    }


    @GetMapping("/getProductList")
    public String  getProductList(){
        List<ProductInfo> productInfos = productClient.listForOrder(Arrays.asList("111","222"));
        log.info("response={}",productInfos);
        return "OK";
    }

}
