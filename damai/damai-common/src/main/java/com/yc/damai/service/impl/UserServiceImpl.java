package com.yc.damai.service.impl;

import com.yc.damai.entity.User;
import com.yc.damai.mapper.UserMapper;
import com.yc.damai.service.IUserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
