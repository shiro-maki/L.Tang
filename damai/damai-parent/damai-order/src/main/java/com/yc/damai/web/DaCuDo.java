package com.yc.damai.web;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.yc.damai.entity.Product;
import com.yc.damai.mapper.ProductMapper;
import com.yc.damai.vo.DacuOrder;
import com.yc.damai.vo.Result;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.data.redis.core.HashOperations;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.SetOperations;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.*;

@RestController
@RequestMapping("dacu")
public class DaCuDo {
    private long beginTime;
    private long length;

    @Resource
    ProductMapper productMapper;

    @Resource
    RedisTemplate redisTemplate;

    @Resource
    RabbitTemplate rabbitTemplate;
    @RequestMapping("begin")

    public String begin(){
        if(beginTime>0){
            return "活动已经开始";
        }
        beginTime=System.currentTimeMillis();
        length=60*60*1000;

        final Date date = new Date(beginTime + length);
        LambdaQueryWrapper<Product> lqw=new LambdaQueryWrapper<>();
        lqw.lt(Product::getPid,11);
        final List<Product> products = productMapper.selectList(lqw);
        System.out.println("products = " + products);
        products.forEach(p->p.setMarketPrice(p.getMarketPrice()*0.8));
        //将商品数据保存到redis中
        final HashOperations opsForHash = redisTemplate.opsForHash();
        products.forEach(p-> opsForHash.put("dacuProducts",p.getPid(), p));

        return "大促活动开始！截止时间"+date;
        //查询pid<=10的商品作为促销的
    }

    @RequestMapping("stop")
    public String stop(){
        beginTime=0;
        length=0;
        clean();
        return "大促活动停止!";
    }

    private void clean(){
        //清理大促商品数据
        redisTemplate.delete("dacuProducts");
        final Set<String>keys = redisTemplate.keys("dacu-*");
        keys.forEach(key->redisTemplate.delete(key));
    }
    //秒杀方法
   @RequestMapping("seckill")
    public Result seckill(int uid,int pid,int num){
        //判断是否处于大促时间
       if(beginTime==0){
           return new Result(0, "大促活动未开始", null);
       }
       final HashOperations opsForHash = redisTemplate.opsForHash();
       Product product=(Product) opsForHash.get("dacuProducts",pid);
       if(product==null){
           return new Result(0, "该商品不是大促商品", null);
       }
       if(product.getCnt()<num){
           return new Result(0, "该商品数量不足",null );
       }
       SetOperations opsForSet = redisTemplate.opsForSet();
       //检查该用户是否之前有秒杀过该商品
      //TODO
       final Boolean member = opsForSet.isMember("dacu-" + uid, pid);
       if(member){
           return new Result(0, "已经秒杀过这个商品了",null);
       }
       //在redis中新增秒杀记录

       opsForSet.add("dacu-"+uid, pid);
       product.setCnt(product.getCnt()-num);
       //保存回redis
       opsForHash.put("dacuProducts",pid,product);
       //向消息队列发送订单消息
       DacuOrder order=new DacuOrder(uid,pid,num);
       rabbitTemplate.convertAndSend("damaiDacu",order);
       //返回结果e
       return new Result(1, "秒杀成功", null);


    }

    @RequestMapping("getDacuProducts")
    public List<Product> getDacuProducts(){
        final HashOperations opsForHash = redisTemplate.opsForHash();
//        System.out.println("opsForHash = " + opsForHash);
        final List<Product> products = opsForHash.values("dacuProducts");
        return products;
    }
    @RequestMapping("getTime")
    public Map<String,Object> getTime(){
        Map<String,Object> map=new HashMap<>();
        map.put("beginTime",beginTime);
        map.put("length",length);
        return map;
    }
}
