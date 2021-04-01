package com.imooc.product.utils;

import com.imooc.product.DTO.CartDTO;
import com.alibaba.fastjson.JSON;

public class FastJsonUsage {
    public static void main(String[] args) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setProductId("123");
        cartDTO.setProductQuantity(100);

        String s = JSON.toJSONString(cartDTO);
        System.out.println(s);
        String t = "{\"productId\":\"123\",\"productQuantity\":100}";
        CartDTO cartDTO1 = JSON.parseObject(t, CartDTO.class);
        System.out.println(cartDTO1);
//        另外常用的方法还有parseArray
//        配合 idea- gson formatter 插件使用
    }
}
