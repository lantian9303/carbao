package com.yeww.carbao.domain.response.common;

import com.yeww.carbao.domain.response.BaseResponse;

/**
 * Created by yeweiwei1 on 2016/8/8.
 */
public class WeatherResponse extends BaseResponse {
    private String thermometer;
    private String weather;
    private String quality;

    public String getThermometer() {
        return thermometer;
    }

    public void setThermometer(String thermometer) {
        this.thermometer = thermometer;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }

    public String getQuality() {
        return quality;
    }

    public void setQuality(String quality) {
        this.quality = quality;
    }
}
