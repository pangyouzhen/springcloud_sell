package com.imooc.product.exceptions;

import com.imooc.product.enums.ResultEnum;

public class ProductException extends RuntimeException {
    private Integer code;

    public ProductException(String s, Integer code) {
        super(s);
        this.code = code;
    }

    public ProductException(ResultEnum resultEnum) {
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
