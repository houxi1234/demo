package com.hx.demo.user.controller;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/user/")
@RefreshScope
public class UserController {

    @Value("${username}")
    private String name;

    @RequestMapping("sayHello")
    public String getUser(@RequestBody String say){
        String result = say + " hi " + name;
        System.out.println(result);
        return result;
    }
    public static void main(String[] argv) throws Exception {
        ConnectionFactory factory = new ConnectionFactory();
        factory.setHost("47.96.21.11");
        factory.setUsername("houxi");
        factory.setPassword("123456");
        factory.setPort(5672);
        Connection connection = factory.newConnection();
        Channel channel = connection.createChannel();

        channel.queueDeclare("houxi", false, false, false, null);
        String message = "Hello World!";
        channel.basicPublish("", "houxi", null, message.getBytes("UTF-8"));
        System.out.println(" [x] Sent '" + message + "'");

        channel.close();
        connection.close();
    }
}
