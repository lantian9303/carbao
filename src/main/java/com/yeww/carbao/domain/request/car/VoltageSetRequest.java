package com.yeww.carbao.domain.request.car;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public class VoltageSetRequest extends BaseRequest {

    private String carId;
    /**
     * 电压开关 1开，0关
     */
    private String voltage;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    @Override
    public String toString() {
        return "SetVoltageRequest{" +
                "carId='" + carId + '\'' +
                "voltage='" + voltage + '\'' +
                '}';
    }
}
