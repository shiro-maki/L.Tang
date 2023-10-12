package com.yc.damai.service.impl;

import com.yc.damai.entity.Category;
import com.yc.damai.mapper.CategoryMapper;
import com.yc.damai.service.ICategoryService;
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
public class CategoryServiceImpl extends ServiceImpl<CategoryMapper, Category> implements ICategoryService {

}
