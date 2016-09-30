package com.yeww.carbao.service.gas;

import com.yeww.carbao.domain.request.gas.CreateOrderRequest;
import com.yeww.carbao.domain.response.gas.CreateOrderResponse;

/**
 * Created by yeweiwei1 on 2016/9/30.
 */
public interface IGasOrderService {
    /**
     * 创建订单
     *
     * @param request
     * @return
     */
    CreateOrderResponse createGasOrder(CreateOrderRequest request);
}
