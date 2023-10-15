package com.yc.damai.web.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

@FeignClient(value="damai-order")
public interface OrderDo {
    @RequestMapping("product/indexProduct")
    Map<String,Object> queryIndexProduct();
}
