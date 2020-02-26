package com.imooc.order.enums;

import lombok.Getter;

@Getter
public enum ResultEnum {
    PARAMETER_ERROR(1, "parameter error"),
    CART_EMPTY(2, "cart empty");
    private Integer code;
    private String message;

    ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
