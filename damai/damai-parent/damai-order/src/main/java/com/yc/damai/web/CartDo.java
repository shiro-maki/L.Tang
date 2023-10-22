package com.yc.damai.web;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import com.yc.damai.biz.CartBiz;
import com.yc.damai.entity.Cart;
import com.yc.damai.mapper.CartMapper;
import com.yc.damai.mapper.MyCartMapper;
import com.yc.damai.vo.Result;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.lang.reflect.Type;
import java.util.List;

@RestController
@RequestMapping("cart")
public class CartDo {
    @Resource
    CartBiz cartBiz;
    @RequestMapping("addProduct")
    public Result addProduct(int uid,int pid){
        cartBiz.addProduct(uid,pid);
        return new Result(1, "商品已经添加到购物车",null);
    }
    @Resource
    MyCartMapper myCartMapper;
    @RequestMapping("findByUid")
    public List<Cart> findByUid(int uid){
//        LambdaQueryWrapper<Cart>lqw=new LambdaQueryWrapper<>();
//        lqw.eq(Cart::getUid,uid) ;
//        return cartMapper.selectList(lqw);
        System.out.println("这是查询结果"+myCartMapper.selectByUid(uid));
        return myCartMapper.selectByUid(uid);
    }
}
