package com.hx.demo.user.service;

import org.springframework.stereotype.Component;

@Component
public class UserServiceHiHystric implements UserService{
    @Override
    public String say(String say) {
        return "error";
    }
}
