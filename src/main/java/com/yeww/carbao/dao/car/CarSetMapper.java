package com.yeww.carbao.dao.car;

import com.yeww.carbao.model.car.CarSetEntity;

import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public interface CarSetMapper {

    int insert(CarSetEntity carSetEntity);

    int update(CarSetEntity carSetEntity);

    CarSetEntity selectOne(Map param);
}
