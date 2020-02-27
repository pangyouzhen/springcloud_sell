package com.imooc.product.service;

import com.imooc.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
class ProductServiceImplTest {

    @Autowired
    private ProductService productService;

    @Test
    public void findupAll() throws Exception{
        List<ProductInfo> list=productService.findupAll();
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findList() throws Exception{
        List<ProductInfo> list = productService.findList(Arrays.asList("111","222"));
        Assert.assertTrue(list.size() > 0 );
    }

}