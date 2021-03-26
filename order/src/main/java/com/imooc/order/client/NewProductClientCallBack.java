package com.imooc.order.client;

import com.imooc.order.dto.CartDTO;
import com.imooc.order.entity.ProductInfo;
import feign.hystrix.FallbackFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Component
public class NewProductClientCallBack implements FallbackFactory<NewProductClient> {
    @Override
    public NewProductClient create(Throwable throwable) {
        return new NewProductClient() {
            @Override
            public String productMsg() {
                log.error("error");
                return new String("报错");
            }

            @Override
            public List<ProductInfo> listForOrder(List<String> productIdlist) {
                return null;
            }

            @Override
            public void decreasseStock(List<CartDTO> cartDTOS) {

            }
        };
    }
}
