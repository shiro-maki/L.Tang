package com.yc.damai.biz;

import com.yc.damai.entity.Cart;
import com.yc.damai.mapper.MyCartMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
@Service
public class CartBiz {
    @Resource
    MyCartMapper mapper;
    @Transactional
    public void addProduct(int uid,int pid){
        final int i=mapper.updateCount(uid,pid);
        if(i==0){
            Cart c=new Cart();
            c.setUid(uid);
            c.setPid(pid);
            c.setCount(1);
            mapper.insert(c);
        }

    }
}
