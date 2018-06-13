package com.hx.demo.user.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/user/")
public class UserController {

    @Autowired
    private RestTemplate restTemplate;
    @RequestMapping("sayHello")
    @HystrixCommand(fallbackMethod = "getUserError")
    public String getUser(@RequestBody String say){
        System.out.println("client");
        ResponseEntity<String> result = restTemplate.postForEntity("http://SERVICE-USER/user/sayHello", say, String.class);
        System.out.println(result);
        return result.getBody();
    }
    public String getUserError(@RequestBody String say){
        return "error";
    }
}
