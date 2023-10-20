package com.yc.damai.web;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.PageDTO;
import com.yc.damai.entity.Product;
import com.yc.damai.mapper.ProductMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("product")
public class ProductDo {

    @Resource
    ProductMapper productMapper;
    @RequestMapping("indexProduct")
    public Map<String,Object> queryIndexProduct(){
         Map<String,Object> res=new HashMap<>();
        LambdaQueryWrapper<Product> lqw=new LambdaQueryWrapper<>();

        lqw.eq(Product::getIsHot,1);
        PageDTO<Product> page=productMapper.selectPage(new PageDTO<>(1,10),lqw);
        List<Product> hots = page.getRecords();
        res.put("hots",hots);
        //最新商品
        lqw=new LambdaQueryWrapper<>();
        lqw.orderByDesc(Product::getPid);
        page= productMapper.selectPage(new PageDTO<>(1,10),lqw);
        List<Product> news = page.getRecords();
        res.put("news",news);
        return res;
    }
    @GetMapping("findById")
    public Product findByID(int pid){
        return productMapper.selectById(pid);
    }
}
