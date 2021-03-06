package com.yeww.carbao.dao.car;

import com.yeww.carbao.model.car.CarEntity;

import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/9/6.
 */
public interface CarMapper {

    CarEntity selectOne(Map paramMap);

    Integer insert(CarEntity entity);

    CarEntity selectById(Long id);

    Integer update(CarEntity carEntity);
}
