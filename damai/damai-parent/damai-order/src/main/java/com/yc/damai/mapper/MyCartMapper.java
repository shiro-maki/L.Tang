package com.yc.damai.mapper;

import com.yc.damai.entity.Cart;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.mapping.FetchType;
import org.springframework.context.annotation.Primary;

import java.util.List;

@Primary
public interface MyCartMapper extends CartMapper{
    @Update("update cart set count=count+1 where uid=#{uid} and pid=#{pid}")
    int updateCount(@Param("uid")int uid,@Param("pid") int pid);

    @Select("select * from cart  where uid=#{uid}")
    @Results(value={
            @Result(column = "ciid",property = "ciid",id = true),
            @Result(column = "pid",property = "pid"),
            @Result(column = "pid",property = "product",
            one=@One(select = "com.yc.damai.mapper.ProductMapper.selectById",fetchType = FetchType.EAGER))

    })
    List<Cart> selectByUid(int uid);
}
