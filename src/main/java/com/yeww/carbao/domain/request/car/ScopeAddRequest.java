package com.yeww.carbao.domain.request.car;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public class ScopeAddRequest extends BaseRequest {

    private String carId;//varchar(50)
    private Double lat;//decimal(10,5)
    private Double lng;//decimal(10,5)
    private String name;//varchar(80)
    private String address;//varchar(500)
    private Double distance;//decimal(10,2)

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
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

    public Double getDistance() {
        return distance;
    }

    public void setDistance(Double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "ScopeAddRequest{" +
                "carId='" + carId + '\'' +
                ", lat='" + lat + '\'' +
                ", lng='" + lng + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", distance='" + distance + '\'' +
                '}';
    }
}
