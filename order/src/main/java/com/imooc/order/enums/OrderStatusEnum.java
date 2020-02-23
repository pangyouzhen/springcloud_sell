package com.imooc.order.enums;

import lombok.Getter;

@Getter
public enum OrderStatusEnum {
    NEW(0,"new"),
    FINISHED(1,"finished"),
    CANCEL(2,"cancel"),
    ;
    private Integer code;
    private String msg;

    OrderStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
