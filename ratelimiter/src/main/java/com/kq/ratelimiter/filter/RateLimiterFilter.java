package com.kq.ratelimiter.filter;

import com.alibaba.fastjson.JSONObject;
import com.google.common.util.concurrent.RateLimiter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * RateLimiterFilter
 *
 * @author kq
 * @date 2018-12-18
 */

@WebFilter(urlPatterns = "/*", filterName = "rateLimiterFilter")
public class RateLimiterFilter implements Filter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    private RateLimiter limiter = null;

    private AtomicLong passAto = new AtomicLong();

    private AtomicLong totalAto = new AtomicLong();

    public void init(FilterConfig config) throws ServletException {
        limiter = RateLimiter.create(100); //request per second
        logger.info("RateLimiter init end.");
    }

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response,
                         FilterChain chain) throws IOException, ServletException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;

        if(limiter.tryAcquire()) {
            logger.debug("pass----------------------totalRequest={}-----successRequest={}",totalAto.getAndIncrement(),passAto.getAndIncrement());
            chain.doFilter(request, response);
        } else {
            logger.debug("system limitation reached! totalRequest={} ",totalAto.getAndIncrement());

            if(this.isAjax(req)) {
                this.out(res);
            } else {
                this.out(res);
//                req.getRequestDispatcher("/jsp/limit.jsp").forward(req,res);
            }


        }
    }


    private void out(HttpServletResponse res) {
        JSONObject json = new JSONObject();
        json.put("code","10000001");
        json.put("message","超过最大请求!");

        try {
            res.getWriter().write(json.toJSONString());
            res.getWriter().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


    private boolean isAjax(HttpServletRequest request){
        String requestType = request.getHeader("X-Requested-With");

//        logger.info("X-Requested-With:{}",requestType);

        if("XMLHttpRequest".equals(requestType)){
            return true;
        }else{
            return false;
        }

    }
}

