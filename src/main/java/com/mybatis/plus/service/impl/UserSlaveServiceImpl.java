package com.mybatis.plus.service.impl;

import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mybatis.plus.entity.User;
import com.mybatis.plus.mapper.UserMapper;
import com.mybatis.plus.service.IUserService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author houfan
 * @since 2021-10-28
 */
@Service("userSlaveService")
@DS("slave_1")
@Transactional(propagation = Propagation.REQUIRES_NEW, rollbackFor = Exception.class)
public class UserSlaveServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

}
