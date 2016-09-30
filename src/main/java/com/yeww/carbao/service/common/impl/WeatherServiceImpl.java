package com.yeww.carbao.service.common.impl;

import com.yeww.carbao.domain.response.common.WeatherResponse;
import com.yeww.carbao.model.common.CityEntiity;
import com.yeww.carbao.service.common.ICityService;
import com.yeww.carbao.service.common.IWeatherService;
import com.yeww.carbao.utils.HttpClientUtil;
import com.yeww.carbao.utils.JsonUtil;
import com.yeww.carbao.utils.StringUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/8/6.
 */
@Service
public class WeatherServiceImpl implements IWeatherService {

    private static final Logger Logs = LoggerFactory.getLogger(WeatherServiceImpl.class);

    @Value("${weather_host}")
    private String weather_host;

    @Value("${weather_app_key}")
    private String weather_app_key;

    @Resource
    private ICityService cityService;


    /**
     * 从host获得相应的city 天气字符串
     *
     * @param cityId 城市id
     * @return
     */
    @Override
    public WeatherResponse getWeatherStr(Long cityId) throws Exception {
        CityEntiity city = cityService.selectById(cityId);
        if (city == null) {
            return null;
        }
        Map<String, Object> paramMap = new HashMap<String, Object>(2);
        paramMap.put("key", weather_app_key);
        paramMap.put("cityname", city.getCityName());
        String response = HttpClientUtil.get(weather_host, paramMap);
        if (StringUtil.isEmpty(response)) {
            return null;
        }

        Map returnMap = JsonUtil.toMap(response);
        if (returnMap == null || (Integer) returnMap.get("error_code") != 0) {
            return null;
        }
        WeatherResponse weatherResponse = new WeatherResponse();
        weatherResponse.setThermometer((String) JsonUtil.getNodeValue(returnMap, "result/data/realtime/weather/temperature"));
        weatherResponse.setWeather(JsonUtil.getNodeValue(returnMap, "result/data/pm25/pm25/level").toString());
        weatherResponse.setQuality((String) JsonUtil.getNodeValue(returnMap, "result/data/pm25/pm25/quality"));
        return weatherResponse;
    }
}
