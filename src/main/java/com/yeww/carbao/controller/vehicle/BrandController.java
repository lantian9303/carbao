package com.yeww.carbao.controller.vehicle;

import com.yeww.carbao.domain.request.vehicle.BrandQueryRequest;
import com.yeww.carbao.domain.request.vehicle.CarTypeQueryRequest;
import com.yeww.carbao.domain.request.vehicle.SubBrandQueryRequest;
import com.yeww.carbao.domain.request.vehicle.YearQueryRequest;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.domain.response.vehicle.BrandQueryResponse;
import com.yeww.carbao.domain.response.vehicle.CarTypeQueryResponse;
import com.yeww.carbao.domain.response.vehicle.SubBrandQueryResponse;
import com.yeww.carbao.domain.response.vehicle.YearQueryResponse;
import com.yeww.carbao.service.vehicle.IVehicleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/18.
 */
@Controller
@RequestMapping(value = "/vehicle/")
public class BrandController {

    private static final Logger Logs = LoggerFactory.getLogger(BrandController.class);

    @Resource
    private IVehicleService vehicleService;

    /**
     * 品牌查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "brand-query")
    @ResponseBody
    public AppResponse<List<BrandQueryResponse>> brandQuery(@RequestBody BrandQueryRequest request) {

        Logs.info("brandQuery参数信息：", request);
        AppResponse<List<BrandQueryResponse>> response = new AppResponse<List<BrandQueryResponse>>();
        try {
            List<BrandQueryResponse> responseList = vehicleService.brandQuery(request);
            response.setData(responseList);
            Logs.info("brandQuery返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }


    /**
     * 车系查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "series-query")
    @ResponseBody
    public AppResponse<List<SubBrandQueryResponse>> subBrandQuery(@RequestBody SubBrandQueryRequest request) {

        Logs.info("subBrandQuery参数信息：", request);
        AppResponse<List<SubBrandQueryResponse>> response = new AppResponse<List<SubBrandQueryResponse>>();
        try {
            List<SubBrandQueryResponse> responseList = vehicleService.subBrandQuery(request);
            response.setData(responseList);
            Logs.info("subBrandQuery返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }

    /**
     * 年份查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "year-query")
    @ResponseBody
    public AppResponse<List<YearQueryResponse>> yearQuery(@RequestBody YearQueryRequest request) {

        Logs.info("yearQuery参数信息：", request);
        AppResponse<List<YearQueryResponse>> response = new AppResponse<List<YearQueryResponse>>();
        try {
            List<YearQueryResponse> responseList = vehicleService.yearQuery(request);
            response.setData(responseList);
            Logs.info("yearQuery返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }

    /**
     * 车型查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "cartype-query")
    @ResponseBody
    public AppResponse<List<CarTypeQueryResponse>> carTypeQuery(@RequestBody CarTypeQueryRequest request) {

        Logs.info("carTypeQuery参数信息：", request);
        AppResponse<List<CarTypeQueryResponse>> response = new AppResponse<List<CarTypeQueryResponse>>();
        try {
            List<CarTypeQueryResponse> responseList = vehicleService.carTypeQuery(request);
            response.setData(responseList);
            Logs.info("carTypeQuery返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }

}
