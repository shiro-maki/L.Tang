package com.yc.login.web;

import com.google.gson.Gson;
import com.yc.login.bean.Result;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        boolean logined = request.getSession().getAttribute("loginedUser")!=null;
        // 判断请求的类型 1.表单请求, 2.ajax请求
        if(request.getHeader("Accept").startsWith("application/json")){
            // ajax
            if(logined == false){
                Result result = new Result(0,"未登录", null);
                final String json = new Gson().toJson(result);
                response.setContentType("application/json;charset=utf-8");
                response.getWriter().append(json);
                return false;
            }
        } else {
            // 表单
            if(logined == false){
                final ServletContext context = request.getServletContext();
                String path = context.getContextPath() + "/login.html";
                response.sendRedirect(path);
                return false;
            }
        }
        return true;
    }
}
