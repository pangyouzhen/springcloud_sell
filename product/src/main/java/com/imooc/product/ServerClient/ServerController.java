package com.imooc.product.ServerClient;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ServerController {


    @GetMapping("/msg")
    public String ServerControoler() {
        return "this is a msg";
    }
}
