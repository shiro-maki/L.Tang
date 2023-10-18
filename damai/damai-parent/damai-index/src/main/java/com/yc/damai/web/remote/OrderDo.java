package com.yc.damai.web.remote;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

@FeignClient(value="damai-order" ,fallback = OrderDoImpl.class)
public interface OrderDo {
    @RequestMapping("product/indexProduct")
    Map<String,Object> queryIndexProduct();

    //
    public static Map<String,Object>cacheMap=new ConcurrentHashMap<>();
    public static void setCache(String name,Object data){
        cacheMap.put(name,data);
    }
    public static Object getCache(String name){
        return cacheMap.get(name);
    }


}
