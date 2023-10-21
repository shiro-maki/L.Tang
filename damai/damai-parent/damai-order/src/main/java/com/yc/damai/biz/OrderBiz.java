package com.yc.damai.biz;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yc.damai.entity.Cart;
import com.yc.damai.entity.Orders;
import com.yc.damai.mapper.CartMapper;
import com.yc.damai.mapper.OrderitemMapper;
import com.yc.damai.mapper.OrdersMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDateTime;

@Service
public class OrderBiz {
    @Resource
    OrdersMapper ordersMapper;
    @Resource
    OrderitemMapper orderitemMapper;
    @Resource
    CartMapper cartMapper;
    @Transactional
    public void addOrder(Orders orders){
        orders.setTotal(0d);
        orders.setState(1);
        orders.setOrdertime(LocalDateTime.now());
      orders.getOrderItems().forEach(orderitem -> {
          orderitem.setSubtotal(orderitem.getCount()*orderitem.getProduct().getMarketPrice());
          orders.setTotal(orders.getTotal()+orderitem.getSubtotal());
      });
      ordersMapper.insert(orders);
        System.out.println("orders.getOid() = " + orders.getOid());

        orders.getOrderItems().forEach(orderitem -> {
            orderitem.setOid(orders.getOid());
            orderitemMapper.insert(orderitem);

            //移除购物商品
            LambdaQueryWrapper<Cart> lqw=new LambdaQueryWrapper<>();
            lqw.eq(Cart::getPid, orderitem.getPid());
            cartMapper.delete(lqw);
        });
    }
}
