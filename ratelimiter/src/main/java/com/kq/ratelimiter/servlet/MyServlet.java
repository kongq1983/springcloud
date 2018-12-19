package com.kq.ratelimiter.servlet;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * MyServlet
 *
 * @author kq
 * @date 2018-12-18
 */
@WebServlet(urlPatterns = "/myservlet", name = "myServlet")
public class MyServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException  {
        this.doPost(req,resp);
    }


    public void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException  {

        JSONObject json = new JSONObject();
        json.put("code","00000");

        resp.getWriter().write(json.toJSONString());
        resp.getWriter().flush();
    }

}
