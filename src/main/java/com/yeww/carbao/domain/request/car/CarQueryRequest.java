package com.yeww.carbao.domain.request.car;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/9/25.
 */
public class CarQueryRequest extends BaseRequest {

    private Long carId;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    @Override
    public String toString() {
        return "CarQueryRequest{" +
                "carId=" + carId +
                '}';
    }
}
