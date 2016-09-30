package com.yeww.carbao.dao.user;

import com.yeww.carbao.model.user.UserEntity;

import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/8/8.
 */
public interface UserMapper {

    int insert(UserEntity userEntity);

    UserEntity selectById(Long id);

    UserEntity selectOne(Map paramMpa);

    void update(UserEntity entity);
}
