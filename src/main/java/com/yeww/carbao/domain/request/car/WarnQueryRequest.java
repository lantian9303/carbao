package com.yeww.carbao.domain.request.car;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public class WarnQueryRequest extends BaseRequest {

    private String carId;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "setWarnRequest{" +
                "carId='" + carId + '\'' +
                '}';
    }
}
