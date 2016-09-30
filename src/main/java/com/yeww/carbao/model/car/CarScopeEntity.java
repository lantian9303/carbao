package com.yeww.carbao.model.car;

import com.yeww.carbao.model.BaseEntity;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public class CarScopeEntity extends BaseEntity {

    private String carId;//varchar(50)
    private String userId;//varchar(50)
    private Double lat;//decimal(10,5)
    private Double lng;//decimal(10,5)
    private String name;//varchar(80)
    private String address;//varchar(500)
    private String distance;//decimal(10,2)
    private String valid_sign;//char(1)1有效 0无效

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

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDistance() {
        return distance;
    }

    public void setDistance(String distance) {
        this.distance = distance;
    }

    public String getValid_sign() {
        return valid_sign;
    }

    public void setValid_sign(String valid_sign) {
        this.valid_sign = valid_sign;
    }
}
