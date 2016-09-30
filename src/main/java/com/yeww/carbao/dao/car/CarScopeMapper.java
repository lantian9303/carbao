package com.yeww.carbao.dao.car;

import com.yeww.carbao.model.car.CarScopeEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public interface CarScopeMapper {

    List<CarScopeEntity> selectList(Map map);

    int insert(CarScopeEntity entity);
}
