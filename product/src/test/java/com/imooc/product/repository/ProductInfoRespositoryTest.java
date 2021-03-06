package com.imooc.product.repository;

import com.imooc.product.dataobject.ProductInfo;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProductInfoRespositoryTest {
    @Autowired
    private ProductInfoRespository productInfoRespository;

    @Test
    public void findByProductStatus() throws Exception {
        List<ProductInfo> list = productInfoRespository.findByProductStatus(0);
        Assert.assertTrue(list.size() > 0);
    }

    @Test
    public void findByProductIdInTest() throws Exception{
        List<ProductInfo> byProductIdIn = productInfoRespository.findByProductIdIn(Arrays.asList("111", "222"));
        Assert.assertTrue(byProductIdIn.size() > 0);
    }
}