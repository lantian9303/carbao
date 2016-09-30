package com.yeww.carbao.dao.vehicle;

import com.yeww.carbao.model.vehicle.VehicleSubBrandEntity;

import java.util.List;

/**
 * Created by yeweiwei1 on 2016/8/17.
 */
public interface VehicleSubBrandMapper {

    int insert(VehicleSubBrandEntity entity);

    VehicleSubBrandEntity selectById(Long id);

    List<VehicleSubBrandEntity> selectByBrandId(Long brandId);
}
