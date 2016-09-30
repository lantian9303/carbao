package com.yeww.carbao.domain.request.common;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/8/8.
 */
public class WeatherRequest extends BaseRequest {

    private String cityId;

    public String getCityId() {
        return cityId;
    }

    public void setCityId(String cityId) {
        this.cityId = cityId;
    }

    @Override
    public String toString() {
        return "WeatherRequest{" +
                super.toString() +
                "cityId='" + cityId + '\'' +
                '}';
    }
}
