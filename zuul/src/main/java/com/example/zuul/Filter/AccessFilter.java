package com.example.zuul.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.Principal;
import java.util.Collection;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

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
        return true;
    }

    @Override
    public Object run() throws ZuulException {
        System.out.println("4");
        RequestContext requestContext = RequestContext.getCurrentContext();
        HttpServletRequest request = requestContext.getRequest();;
        String token = request.getRequestURI();
        System.out.println(token);
        return null;
    }
}
