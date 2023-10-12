package com.yc.damai.service.impl;

import com.yc.damai.entity.Cart;
import com.yc.damai.mapper.CartMapper;
import com.yc.damai.service.ICartService;
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
public class CartServiceImpl extends ServiceImpl<CartMapper, Cart> implements ICartService {

}
