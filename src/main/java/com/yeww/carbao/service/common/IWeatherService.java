package com.yeww.carbao.service.common;

import com.yeww.carbao.domain.response.common.WeatherResponse;

/**
 * Created by yeweiwei1 on 2016/8/6.
 */
public interface IWeatherService {

    /**
     * 从host获得相应的city 天气字符串
     *
     * @param cityId 城市代码
     * @return
     */

    public WeatherResponse getWeatherStr(Long cityId) throws Exception;
}
