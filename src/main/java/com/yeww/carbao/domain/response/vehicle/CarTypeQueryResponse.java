package com.yeww.carbao.domain.response.vehicle;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.vehicle.CarInfoEntity;

/**
 * Created by yeweiwei1 on 2016/9/24.
 */
public class CarTypeQueryResponse extends BaseResponse<CarInfoEntity> {

    private Integer typeId;
    private String name;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void converter(CarInfoEntity entity) {
        this.typeId = entity.getId().intValue();
        this.name=entity.getName();
    }

    @Override
    public String toString() {
        return "CarTypeQueryResponse{" +
                "typeId=" + typeId +
                ", name='" + name + '\'' +
                '}';
    }
}
