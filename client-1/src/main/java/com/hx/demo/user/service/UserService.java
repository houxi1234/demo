package com.hx.demo.user.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@FeignClient(value = "SERVICE-USER", fallback = UserServiceHiHystric.class)
public interface UserService {

    @RequestMapping(value = "/user/sayHello",method = RequestMethod.POST)
    String say(String say);
}
