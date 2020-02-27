package com.imooc.product.service.impl;

import com.imooc.product.DTO.CartDTO;
import com.imooc.product.dataobject.ProductInfo;
import com.imooc.product.enums.ProductStatusEnum;
import com.imooc.product.enums.ResultEnum;
import com.imooc.product.exceptions.ProductException;
import com.imooc.product.repository.ProductCategoryRespository;
import com.imooc.product.repository.ProductInfoRespository;
import com.imooc.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

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

    @Override
    public List<ProductInfo> findList(List<String> productIdList) {
        return productInfoRespository.findByProductIdIn(productIdList);
    }

    @Override
    @Transactional
    public void decreaseStock(List<CartDTO> cartDTOList) {
            for (CartDTO cartDTO:cartDTOList){
                Optional<ProductInfo> productInfoOptional = productInfoRespository.findById(cartDTO.getProductId());
                if (!productInfoOptional.isPresent()){
                     throw new ProductException(ResultEnum.PRODUCT_NOT_EXIST);
                }
                ProductInfo productInfo = productInfoOptional.get();
                Integer result = productInfo.getProductStock() - cartDTO.getProductQuantity();
                if (result < 0){
                    throw new ProductException(ResultEnum.PRODUCT_STOCK_ERROR);
                }

                productInfo.setProductStock(result);
                productInfo.setCreateTime(new Date());
                productInfo.setUpdateTime(new Date());
                productInfoRespository.save(productInfo);
            }
    }

}
