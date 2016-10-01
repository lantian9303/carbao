package com.yeww.carbao.dao.vehicle;

import com.yeww.carbao.model.vehicle.VehicleBrandEntity;

import java.util.List;

/**
 * Created by yeweiwei1 on 2016/8/17.
 */
public interface VehicleBrandMapper {

    Integer insert(VehicleBrandEntity entity);

    VehicleBrandEntity selectById(Long id);

    List<VehicleBrandEntity> selectAll();
}
