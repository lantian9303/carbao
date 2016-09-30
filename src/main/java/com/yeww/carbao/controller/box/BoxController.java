package com.yeww.carbao.controller.box;

import com.yeww.carbao.domain.request.box.CreateBoxOrderRequest;
import com.yeww.carbao.domain.request.box.QueryBoxOrderRequest;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.domain.response.box.CreateBoxOrderResponse;
import com.yeww.carbao.domain.response.box.QueryBoxOrderResponse;
import com.yeww.carbao.domain.response.box.QueryBoxResponse;
import com.yeww.carbao.service.box.IBoxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/30.
 */
@Controller
@RequestMapping(value = "/box/")
public class BoxController {

    private static final Logger Logs = LoggerFactory.getLogger(BoxController.class);

    @Resource
    private IBoxService boxService;

    /**
     * 盒子详情查询
     *
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public AppResponse<QueryBoxResponse> boxQuery() {
//        Logs.info("query参数信息：", request);
        AppResponse<QueryBoxResponse> response = new AppResponse<QueryBoxResponse>();
        try {
            QueryBoxResponse boxResponse = boxService.boxQuery();
            response.setData(boxResponse);
            Logs.info("boxQuery返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }

    /**
     * 盒子详情查询
     *
     * @return
     */
    @RequestMapping(value = "create-box-order")
    @ResponseBody
    public AppResponse<CreateBoxOrderResponse> createBoxOrder(CreateBoxOrderRequest request) {
        Logs.info("createBoxOrder参数信息：", request);
        AppResponse<CreateBoxOrderResponse> response = new AppResponse<CreateBoxOrderResponse>();
        try {
            CreateBoxOrderResponse createBoxOrderResponse = boxService.createBoxOrder(request);
            response.setData(createBoxOrderResponse);
            Logs.info("createBoxOrder返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }

    /**
     * 盒子详情查询
     *
     * @return
     */
    @RequestMapping(value = "query-order-list")
    @ResponseBody
    public AppResponse<List<QueryBoxOrderResponse>> queryBoxOrderList(QueryBoxOrderRequest request) {
        Logs.info("queryBoxOrderList参数信息：", request);
        AppResponse<List<QueryBoxOrderResponse>> response = new AppResponse<List<QueryBoxOrderResponse>>();
        try {
            List<QueryBoxOrderResponse> createBoxOrderResponse = boxService.queryBoxOrderList(request);
            response.setData(createBoxOrderResponse);
            Logs.info("queryBoxOrderList返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
