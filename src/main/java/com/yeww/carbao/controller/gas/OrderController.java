package com.yeww.carbao.controller.gas;

import com.yeww.carbao.domain.request.gas.CreateOrderRequest;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.domain.response.gas.CreateOrderResponse;
import com.yeww.carbao.service.gas.IGasOrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
@Controller
@RequestMapping(value = "/gas/order/")
public class OrderController {

    private static final Logger Logs = LoggerFactory.getLogger(OrderController.class);

    @Resource
    private IGasOrderService gasOrderService;

    /**
     * 加油订单创建
     *
     * @return
     */
    @RequestMapping(value = "create-gas-order")
    @ResponseBody
    public AppResponse<CreateOrderResponse> createGasOrder(CreateOrderRequest request) {
        Logs.info("createGasOrder参数信息：", request);
        AppResponse<CreateOrderResponse> response = new AppResponse<CreateOrderResponse>();
        try {
            CreateOrderResponse createOrderResponse = gasOrderService.createGasOrder(request);
            response.setData(createOrderResponse);
            Logs.info("createGasOrder返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
