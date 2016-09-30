package com.yeww.carbao.model.car;

import com.yeww.carbao.model.BaseEntity;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public class CarSetEntity extends BaseEntity {
    private String carId;
    private String userId;
    private String voltage;
    private String start;
    private String over_speed;
    private String shake;
    private String scope;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getVoltage() {
        return voltage;
    }

    public void setVoltage(String voltage) {
        this.voltage = voltage;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getOver_speed() {
        return over_speed;
    }

    public void setOver_speed(String over_speed) {
        this.over_speed = over_speed;
    }

    public String getShake() {
        return shake;
    }

    public void setShake(String shake) {
        this.shake = shake;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    @Override
    public String toString() {
        return "CarSetEntity{" +
                "carId='" + carId + '\'' +
                ", userId='" + userId + '\'' +
                ", voltage='" + voltage + '\'' +
                ", start='" + start + '\'' +
                ", over_speed='" + over_speed + '\'' +
                ", shake='" + shake + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
