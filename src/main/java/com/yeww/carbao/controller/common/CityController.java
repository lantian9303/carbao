package com.yeww.carbao.controller.common;

import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.domain.response.common.CityQueryResponse;
import com.yeww.carbao.service.common.ICityService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/8/8.
 */
@Controller
@RequestMapping(value = "/common/city/")
public class CityController {

    private static final Logger Logs = LoggerFactory.getLogger(CityController.class);
    @Resource
    private ICityService cityService;

    @RequestMapping(value = "get-data")
    @ResponseBody
    public AppResponse getAll() {
        AppResponse<List<CityQueryResponse>> response = new AppResponse<List<CityQueryResponse>>();
        try {
            List<CityQueryResponse> infos = cityService.getCityInfo();
            response.setData(infos);
            Logs.info("getAll返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
