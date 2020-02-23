package com.imooc.product.service.impl;

import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.repository.ProductCategoryRespository;
import com.imooc.product.repository.ProductInfoRespository;
import com.imooc.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductCategoryRespository productCategoryRespository;

    @Autowired
    private ProductInfoRespository productInfoRespository;

    @Override
    public List<ProductInfo> findupAll() {
        return productInfoRespository.findByProductStatus(ProductStatusEnum.UP.getCode());
    }

}
