package com.yc.damai.web;

import com.yc.damai.biz.OrderBiz;
import com.yc.damai.entity.Orderitem;
import com.yc.damai.entity.Orders;
import com.yc.damai.entity.Product;
import com.yc.damai.entity.User;
import com.yc.damai.mapper.MyOrdersMapper;
import com.yc.damai.mapper.ProductMapper;
import com.yc.damai.mapper.UserMapper;
import com.yc.damai.vo.DacuOrder;
import com.yc.damai.vo.Result;
import io.micrometer.core.instrument.util.AbstractPartition;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

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

    @Resource
    UserMapper userMapper;
    @Resource
    ProductMapper productMapper;
    //处理大促订单
    @RabbitListener(queuesToDeclare =@Queue(value = "damaiDacu"))
    public void addDacuOrder(DacuOrder dacuOrder){
        Orders orders=new Orders();
        final User user = userMapper.selectById(dacuOrder.getUid());
        final Product product = productMapper.selectById(dacuOrder.getPid());
        orders.setUid(dacuOrder.getUid());
        orders.setAddr(user.getAddr());
        orders.setPhone(user.getPhone());
        orders.setName(orders.getName());
        List<Orderitem> orderitems=new ArrayList<>();
        Orderitem orderitem=new Orderitem();
        orderitem.setProduct(product);
        orderitem.setPid(product.getPid());
        orderitem.setCount(dacuOrder.getNum());
        orderitems.add(orderitem);
        orders.setOrderItems(orderitems);
        final Result result=addOrder(orders);
        System.out.println("result = " + result);

    }

    @RequestMapping("findById")
    public Orders addOrder(int oid){

        return myOrdersMapper.queryById(oid);
    }
}
