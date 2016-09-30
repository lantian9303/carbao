package com.yeww.carbao.model.vehicle;

import com.yeww.carbao.model.BaseEntity;

/**
 * Created by yeweiwei1 on 2016/9/24.
 */
public class VehicleSubBrandEntity extends BaseEntity {
    private Long brandId;
    private String brandName;
    private String subBrandName;
    private String comName;

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getSubBrandName() {
        return subBrandName;
    }

    public void setSubBrandName(String subBrandName) {
        this.subBrandName = subBrandName;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    @Override
    public String toString() {
        return "VehicleSubBrandEntity{" +
                "brandId=" + brandId +
                ", brandName='" + brandName + '\'' +
                ", subBrandName='" + subBrandName + '\'' +
                ", comName='" + comName + '\'' +
                '}';
    }
}
