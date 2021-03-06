package com.imooc.product.service;

import com.imooc.product.DTO.CartDTO;
import com.imooc.product.dataobject.ProductInfo;

import java.util.List;

public interface ProductService {
    List<ProductInfo> findupAll();


    List<ProductInfo> findList(List<String> productIdList);

    void decreaseStock(List<CartDTO> cartDTOList);
}
