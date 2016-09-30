package com.yeww.carbao.model.vehicle;

import com.yeww.carbao.model.BaseEntity;

/**
 * Created by yeweiwei1 on 2016/9/24.
 */
public class CarInfoEntity extends BaseEntity {
    private Long brandId;
    private Long subBrandId;
    private String year;
    private String name;
    private String carType;
    private String trans;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getSubBrandId() {
        return subBrandId;
    }

    public void setSubBrandId(Long subBrandId) {
        this.subBrandId = subBrandId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public String getTrans() {
        return trans;
    }

    public void setTrans(String trans) {
        this.trans = trans;
    }

    @Override
    public String toString() {
        return "CarInfoEntity{" +
                "brandId=" + brandId +
                ", subBrandId=" + subBrandId +
                ", year=" + year +
                ", name=" + name +
                ", carType=" + carType +
                ", trans=" + trans +
                '}';
    }
}
