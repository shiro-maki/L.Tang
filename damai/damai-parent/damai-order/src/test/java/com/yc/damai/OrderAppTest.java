//package com.yc.damai;
//
//import com.yc.damai.biz.OrderBiz;
//import com.yc.damai.entity.Orderitem;
//import com.yc.damai.entity.Orders;
//import com.yc.damai.entity.Product;
//import org.junit.jupiter.api.Test;
//import org.springframework.boot.test.context.SpringBootTest;
//
//import javax.annotation.Resource;
//import java.util.ArrayList;
//import java.util.List;
//
//@SpringBootTest
//public class OrderAppTest {
//    @Resource
//    OrderBiz orderBiz;
//    @Test
//    public void test1(){
//        Orders orders=new Orders();
//        orders.setUid(1);
//        orders.setAddr("工学院");
//        orders.setPhone("12345678900");
//        orders.setName("张三");
//        List<Orderitem> items=new ArrayList<>();
//        Orderitem oi=new Orderitem();
//        oi.setPid(1);
//        oi.setCount(1);
//        Product p=new Product();
//        p.setMarketPrice(558d);
//        oi.setProduct(p);
//        items.add(oi);
//        orders.setOrderItems(items);
//        orderBiz.addOrder(orders);
//    }
//}
