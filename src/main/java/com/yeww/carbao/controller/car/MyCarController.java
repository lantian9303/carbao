package com.yeww.carbao.controller.car;

import com.yeww.carbao.domain.request.car.CarQueryRequest;
import com.yeww.carbao.domain.request.car.CarUpdateRequest;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.model.car.CarEntity;
import com.yeww.carbao.service.car.ICarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by yeweiwei1 on 2016/9/24.
 */
@Controller
@RequestMapping(value = "/car/")
public class MyCarController {

    private static final Logger Logs = LoggerFactory.getLogger(MyCarController.class);

    @Resource
    private ICarService carService;

    @RequestMapping(value = "save")
    @ResponseBody
    public AppResponse save(@RequestBody CarUpdateRequest request) {
        Logs.info("save参数信息：", request);
        AppResponse response = new AppResponse();
        try {
            carService.save(request);
            Logs.info("save返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }

    @RequestMapping(value = "query")
    @ResponseBody
    public AppResponse<CarEntity> query(@RequestBody CarQueryRequest request) {
        Logs.info("query参数信息：", request);
        AppResponse<CarEntity> response = new AppResponse<CarEntity>();
        try {
            CarEntity carEntityList = carService.query(request);
            response.setData(carEntityList);
            Logs.info("query返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
