package com.yeww.carbao.domain.response.vehicle;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.vehicle.CarInfoEntity;

/**
 * Created by yeweiwei1 on 2016/9/24.
 */
public class YearQueryResponse extends BaseResponse<CarInfoEntity> {

    private String year;

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public void converter(CarInfoEntity entity) {
        this.year = entity.getYear();
    }

    @Override
    public String toString() {
        return "YearQueryResponse{" +
                "year='" + year + '\'' +
                '}';
    }
}
