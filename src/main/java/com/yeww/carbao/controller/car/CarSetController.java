package com.yeww.carbao.controller.car;

import com.yeww.carbao.domain.request.car.WarnQueryRequest;
import com.yeww.carbao.domain.request.car.VoltageSetRequest;
import com.yeww.carbao.domain.request.car.WarnSetRequest;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.model.car.CarSetEntity;
import com.yeww.carbao.service.car.ICarSetService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
@Controller
@RequestMapping(value = "/car-set/")
public class CarSetController {

    private static final Logger Logs = LoggerFactory.getLogger(CarSetController.class);

    @Resource
    private ICarSetService carSetService;

    /**
     * 设置电压
     *
     * @return
     */
    @RequestMapping(value = "voltage")
    @ResponseBody
    public AppResponse setVoltage(@RequestBody VoltageSetRequest request) {
        Logs.info("setVoltage参数信息：", request);
        AppResponse response = new AppResponse();
        try {
            carSetService.setVoltage(request);
            Logs.info("setVoltage返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }

    /**
     * 设置 报警设置
     *
     * @return
     */
    @RequestMapping(value = "warn")
    @ResponseBody
    public AppResponse setWarn(@RequestBody WarnSetRequest request) {
        Logs.info("setWarn参数信息：", request);
        AppResponse response = new AppResponse();
        try {
            carSetService.setWarn(request);
            Logs.info("setWarn返回信息：", response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }

    /**
     * 查询 报警设置
     *
     * @return
     */
    @RequestMapping(value = "query/warn")
    @ResponseBody
    public AppResponse queryWarn(@RequestBody WarnQueryRequest request) {
        Logs.info("queryWarn参数信息：", request);
        AppResponse<CarSetEntity> response = new AppResponse<CarSetEntity>();
        try {
            CarSetEntity carSetEntity = carSetService.queryWarn(request);
            response.setData(carSetEntity);
            Logs.info("queryWarn返回信息：", response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
