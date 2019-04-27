package com.dxh.demo2war.mts.mapper.dal;

import com.dxh.demo2war.mts.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapperDal {

    User selectById(Long id);

}
