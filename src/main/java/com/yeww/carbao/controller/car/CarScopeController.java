package com.yeww.carbao.controller.car;

import com.yeww.carbao.domain.request.car.ScopeAddRequest;
import com.yeww.carbao.domain.request.car.ScopeQueryRequest;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.model.car.CarScopeEntity;
import com.yeww.carbao.service.car.ICarScopeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
@Controller
@RequestMapping(value = "/car-scope/")
public class CarScopeController {

    private static final Logger Logs = LoggerFactory.getLogger(CarSetController.class);

    @Resource
    private ICarScopeService carScopeService;

    @RequestMapping(value = "save")
    @ResponseBody
    public AppResponse add(@RequestBody ScopeAddRequest request) {
        Logs.info("save参数信息：", request);
        AppResponse response = new AppResponse();
        try {
            carScopeService.add(request);
            Logs.info("save返回信息：" + response);
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
    @RequestMapping(value = "query")
    @ResponseBody
    public AppResponse query(@RequestBody ScopeQueryRequest request) {
        Logs.info("query参数信息：", request);
        AppResponse<List<CarScopeEntity>> response = new AppResponse<List<CarScopeEntity>>();
        try {
            List<CarScopeEntity> carSetEntity = carScopeService.query(request);
            response.setData(carSetEntity);
            Logs.info("query返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
