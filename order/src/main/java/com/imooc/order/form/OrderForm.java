package com.imooc.order.form;

import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
public class OrderForm {

    @NotEmpty(message = "name")
    private String name;

    @NotEmpty(message = "phone")
    private String phone;


    @NotEmpty(message = "address")
    private String address;

    @NotEmpty(message = "openid")
    private String openid;

    @NotEmpty(message = "items")
    private String items;
}
