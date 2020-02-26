package com.imooc.order.exceptions;

import com.imooc.order.enums.ResultEnum;

import javax.xml.transform.Result;

public class OrderException extends RuntimeException{

    private Integer code;

    public OrderException(Integer code,String message) {
        super(message);
        this.code = code;
    }

    public OrderException(ResultEnum resultEnum ){
        super(resultEnum.getMessage());
        this.code = resultEnum.getCode();
    }
}
