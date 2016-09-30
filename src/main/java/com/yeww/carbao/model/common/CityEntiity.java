package com.yeww.carbao.model.common;

import com.yeww.carbao.model.BaseEntity;

/**
 * Created by yeweiwei1 on 2016/8/8.
 */
public class CityEntiity extends BaseEntity {
    private Long pid;

    private String cityType;

    private String cityName;

    private String cityZh;

    private String cityCode;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getCityType() {
        return cityType;
    }

    public void setCityType(String cityType) {
        this.cityType = cityType;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCityCode() {
        return cityCode;
    }

    public void setCityCode(String cityCode) {
        this.cityCode = cityCode;
    }

    public String getCityZh() {
        return cityZh;
    }

    public void setCityZh(String cityZh) {
        this.cityZh = cityZh;
    }
}

