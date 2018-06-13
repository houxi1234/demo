package com.hx.demo.user.controller;

import com.hx.demo.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private UserService userService;
    @RequestMapping("sayHello")
    public String getUser(@RequestBody String say){
        System.out.println("client-1");
        String result = userService.say(say);
        System.out.println(result);
        return result;
    }
}
