package com.example.zuul.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

public class AccessFilter  extends ZuulFilter {
    @Override
    public String filterType() {
        System.out.println("1");
        return "pre";
    }

    @Override
    public int filterOrder() {
        System.out.println("2");
        return 0;
    }

    @Override
    public boolean shouldFilter() {
        System.out.println("3");
        return false;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("4");
        return null;
    }
}
