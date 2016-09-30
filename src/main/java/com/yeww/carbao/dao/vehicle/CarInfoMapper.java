package com.yeww.carbao.dao.vehicle;

import com.yeww.carbao.model.vehicle.CarInfoEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/8/17.
 */
public interface CarInfoMapper {

    int insert(CarInfoEntity entity);

    CarInfoEntity selectById(Long id);

    List<CarInfoEntity> selectBySubBrandId(Long subBrandId);

    List<CarInfoEntity> selectByMap(Map map);
}
