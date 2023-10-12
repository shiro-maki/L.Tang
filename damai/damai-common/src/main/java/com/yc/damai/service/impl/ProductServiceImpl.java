package com.yc.damai.service.impl;

import com.yc.damai.entity.Product;
import com.yc.damai.mapper.ProductMapper;
import com.yc.damai.service.IProductService;
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
public class ProductServiceImpl extends ServiceImpl<ProductMapper, Product> implements IProductService {

}
