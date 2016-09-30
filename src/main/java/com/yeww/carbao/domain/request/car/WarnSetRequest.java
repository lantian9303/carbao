package com.yeww.carbao.domain.request.car;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public class WarnSetRequest extends BaseRequest {

    private String carId;
    private String start;
    private String overSpeed;
    private String shake;
    private String scope;

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getStart() {
        return start;
    }

    public void setStart(String start) {
        this.start = start;
    }

    public String getOverSpeed() {
        return overSpeed;
    }

    public void setOverSpeed(String overSpeed) {
        this.overSpeed = overSpeed;
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
        return "setWarnRequest{" +
                "carId='" + carId + '\'' +
                ", start='" + start + '\'' +
                ", overSpeed='" + overSpeed + '\'' +
                ", shake='" + shake + '\'' +
                ", scope='" + scope + '\'' +
                '}';
    }
}
