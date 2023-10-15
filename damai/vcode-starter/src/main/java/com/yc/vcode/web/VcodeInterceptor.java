package com.yc.vcode.web;

import com.google.gson.Gson;
import com.yc.vcode.bean.Result;
import org.springframework.validation.BindException;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class VcodeInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String vcode = (String) request.getSession().getAttribute("vcode");
        final String rcode = request.getParameter("vcode");
        String msg;
        if (vcode == null) {
            msg = "会话中缺失验证码!";
        } else if (rcode == null) {
            msg = "请输入验证码!";
        } else if (vcode.equalsIgnoreCase(rcode) == false) {
            msg = "验证码输入错误!";
        } else {
            return true;  // true 允许访问
        }

        // 判断请求的类型 1.表单请求, 2.ajax请求
        if (request.getHeader("Accept").startsWith("application/json")) {
            Result result = new Result(0, msg, null);
            final String json = new Gson().toJson(result);
            response.setContentType("application/json;charset=utf-8");
            response.getWriter().append(json);
        } else {
            // 表单
            final String referer = request.getHeader("Referer");
            response.sendRedirect(referer);
        }
        return false;
    }
}
