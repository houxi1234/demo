package com.hx.demo.user.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Value("${server.port}")
    private String port;

    @RequestMapping("sayHello")
    public String getUser(@RequestBody String say) throws InterruptedException {
        //int a = 1/0;
        System.out.println("超时");
        Thread.sleep(120000L);
        return say + " say hello! port=" + port;
    }
}
