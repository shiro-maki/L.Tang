package com.example.cloud.web;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// @Component
public class TokenFilter extends ZuulFilter {


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
    public Object run() throws ZuulException {
        final RequestContext context = RequestContext.getCurrentContext();
        final HttpServletRequest request = context.getRequest();
        final String token = request.getParameter("token");
        if (token == null) {
            context.setResponseStatusCode(400);
            // 不允许访问目标资源
            context.setSendZuulResponse(false);
            final String json = String.format("{\"code\":0, \"msg\":\"not token!!\"}");
            context.setResponseBody(json);
        }
        return null;
    }
}
