package com.yc.damai.web;

import com.yc.damai.web.remote.OrderDo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;
@RestController
public class IndexDo {
    @Resource
    OrderDo orderDo;

    @RequestMapping("indexProduct")
    Map<String,Object> queryIndexProduct(){
        return orderDo.queryIndexProduct();
    }
}
