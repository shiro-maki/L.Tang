package com.yc.damai.mapper;

import com.yc.damai.entity.Orderitem;
import com.yc.damai.entity.Orders;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Primary
public interface MyOrdersMapper extends OrdersMapper{
    @Select("select * from orders where oid=#{oid}" )
    @Results(
            value={
                    @Result(column = "oid",property = "oid",id = true),
                    @Result(column = "oid",property = "orderItems",
                    many=@Many(
                            select="queryByOid",fetchType = FetchType.EAGER
                    )),
                    @Result(column = "uid",property = "uid"),
                    @Result(column = "uid",property = "user",
                    one=@One(select = "com.yc.damai.mapper.UserMapper.selectById",fetchType = FetchType.EAGER))
            }
    )
    public Orders queryById(int id);

    @Select("select * from orderitem where oid=#{oid}" )
    @Results(value={
            @Result(column = "itemid",property = "itemid",id = true),
            @Result(column = "pid",property = "pid"),
            @Result(column = "pid",property = "product",
                    one=@One(select = "com.yc.damai.mapper.ProductMapper.selectById",fetchType = FetchType.EAGER))

    })
    public List<Orderitem> queryByOid(int oid);
}
