package com.yc.damai.service.impl;

import com.yc.damai.entity.Orders;
import com.yc.damai.mapper.OrdersMapper;
import com.yc.damai.service.IOrdersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author tl
 * @since 2023-10-11
 */
@Service
public class OrdersServiceImpl extends ServiceImpl<OrdersMapper, Orders> implements IOrdersService {

}
