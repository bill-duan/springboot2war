package com.dxh.demo2war.mts.service;

import com.dxh.demo2war.mts.entity.User;

public interface UserService {

    void save(User user);

    User findById(Long userId);

    User findByIdDal(Long userId);

}
