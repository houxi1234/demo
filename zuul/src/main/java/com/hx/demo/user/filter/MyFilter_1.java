package com.hx.demo.user.filter;


import com.netflix.zuul.ZuulFilter;
import org.springframework.stereotype.Component;

@Component
public class MyFilter_1 extends ZuulFilter {
    @Override
    public String filterType() {
        return "pre";
    }

    @Override
    public int filterOrder() {
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        return true;
    }

    @Override
    public Object run() {
        System.out.println("pre");
        return null;
    }
}

