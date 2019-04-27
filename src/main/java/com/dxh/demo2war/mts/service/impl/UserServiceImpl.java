package com.dxh.demo2war.mts.service.impl;

import com.dxh.demo2war.mts.entity.User;
import com.dxh.demo2war.mts.mapper.dal.UserMapperDal;
import com.dxh.demo2war.mts.mapper.dao.UserMapper;
import com.dxh.demo2war.mts.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    @SuppressWarnings("all")
    private UserMapper userMapper;

    @Autowired
    @SuppressWarnings("all")
    private UserMapperDal userMapperDal;

    @Override
    public void save(User user) {
        userMapper.insert(user);
    }

    @Override
    public User findById(Long userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User findByIdDal(Long userId) {
        return userMapperDal.selectById(userId);
    }
}
