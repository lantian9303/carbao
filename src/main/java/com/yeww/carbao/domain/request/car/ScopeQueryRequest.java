package com.yeww.carbao.domain.request.car;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public class ScopeQueryRequest extends BaseRequest {

    private String carId;//varchar(50)

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "ScopeAddRequest{" +
                "carId='" + carId + '\'' +
                '}';
    }
}
