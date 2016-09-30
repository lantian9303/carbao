package com.yeww.carbao.domain.response.vehicle;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.vehicle.VehicleBrandEntity;

import java.io.Serializable;

/**
 * Created by yeweiwei1 on 2016/9/24.
 */
public class BrandQueryResponse extends BaseResponse<VehicleBrandEntity> implements Serializable{

    private String brandId;
    private String name;

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void converter(VehicleBrandEntity entity) {
        this.brandId=Long.toString(entity.getId());
        this.name=entity.getName();
    }

    @Override
    public String toString() {
        return "BrandQueryResponse{" +
                "brandId='" + brandId + '\'' +
                ", name='" + name + '\'' +
                '}';
    }
}
