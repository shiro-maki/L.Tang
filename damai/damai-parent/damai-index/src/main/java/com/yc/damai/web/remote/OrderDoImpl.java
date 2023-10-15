package com.yc.damai.web.remote;

import java.util.Map;

public class OrderDoImpl implements OrderDo{
    Map<String,Object> indexProduct;
    @Override
    public Map<String, Object> queryIndexProduct() {
        return indexProduct;
    }
//缓存首页商品数据
    public void catchQueryIndexProduct(Map<String, Object> indexProduct) {
        this.indexProduct=indexProduct;
    }

}
