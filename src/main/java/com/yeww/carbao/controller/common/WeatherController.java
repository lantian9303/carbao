package com.yeww.carbao.controller.common;

import com.yeww.carbao.domain.request.common.WeatherRequest;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.domain.response.common.WeatherResponse;
import com.yeww.carbao.service.common.IWeatherService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by yeweiwei1 on 2016/8/6.
 */
@Controller
@RequestMapping(value = "/common/")
public class WeatherController {
    private static final Logger Logs = LoggerFactory.getLogger(WeatherController.class);

    @Resource
    private IWeatherService weatherService;

    @RequestMapping(value = "get-weather")
    @ResponseBody
    public AppResponse getWeather(@RequestBody WeatherRequest request){
        AppResponse<WeatherResponse> response = new AppResponse<WeatherResponse>();
        try {
            WeatherResponse weather= weatherService.getWeatherStr(Long.parseLong(request.getCityId()));
            response.setData(weather);
            Logs.info("getWeather返回信息："+ response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
