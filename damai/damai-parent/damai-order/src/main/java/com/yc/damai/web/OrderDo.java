package com.yc.damai.web;

import com.yc.damai.biz.OrderBiz;
import com.yc.damai.entity.Orders;
import com.yc.damai.mapper.MyOrdersMapper;
import com.yc.damai.vo.Result;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
@RequestMapping("order")
public class OrderDo {
    @Resource
    OrderBiz orderBiz;
    @RequestMapping("addOrder")
    public Result addOrder(@RequestBody  Orders orders){
        orderBiz.addOrder(orders);
        return new Result(1, "订单提交成功", null);
    }
    @Resource
    MyOrdersMapper myOrdersMapper;

    @RequestMapping("findById")
    public Orders addOrder(int oid){

        return myOrdersMapper.queryById(oid);
    }
}
