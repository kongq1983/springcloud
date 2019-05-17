package com.kq.springmvc.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 转发过滤器
 * ForwardFilter
 * @author kq
 * @date 2018-12-13
 */

//@Component
//@WebFilter(filterName="forwardFilter",urlPatterns="/115/*")
public class ForwardFilter implements Filter {

    private Logger log = LoggerFactory.getLogger(ForwardFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }


    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain)
            throws IOException, ServletException {

        HttpServletRequest req = (HttpServletRequest)request;
        HttpServletResponse res = (HttpServletResponse) response;


        res.sendRedirect("");


    }

    @Override
    public void destroy() {

    }


}
