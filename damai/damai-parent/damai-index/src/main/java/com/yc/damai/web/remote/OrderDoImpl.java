package com.yc.damai.web.remote;

import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class OrderDoImpl implements OrderDo{
    Map<String,Object> indexProduct;
    @Override
    public Map<String, Object> queryIndexProduct() {
        return (Map<String, Object>) OrderDo.getCache("indexProduct");
    }

}
