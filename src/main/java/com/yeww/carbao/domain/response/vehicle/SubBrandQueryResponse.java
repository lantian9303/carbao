package com.yeww.carbao.domain.response.vehicle;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.vehicle.VehicleSubBrandEntity;

/**
 * Created by yeweiwei1 on 2016/9/24.
 */
public class SubBrandQueryResponse extends BaseResponse<VehicleSubBrandEntity> {

    private String seriesId;
    private String name;

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void converter(VehicleSubBrandEntity entity) {
        this.seriesId=Long.toString(entity.getId());
        this.name=entity.getSubBrandName();
    }
}
