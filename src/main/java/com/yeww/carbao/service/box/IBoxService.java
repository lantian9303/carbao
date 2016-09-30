package com.yeww.carbao.service.box;

import com.yeww.carbao.domain.request.box.CreateBoxOrderRequest;
import com.yeww.carbao.domain.request.box.QueryBoxOrderRequest;
import com.yeww.carbao.domain.response.box.CreateBoxOrderResponse;
import com.yeww.carbao.domain.response.box.QueryBoxOrderResponse;
import com.yeww.carbao.domain.response.box.QueryBoxResponse;

import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/30.
 */
public interface IBoxService {
    /**
     * 盒子信息查询
     *
     * @return
     */
    QueryBoxResponse boxQuery();

    /**
     * 创建盒子订单
     *
     * @param request
     * @return
     */
    CreateBoxOrderResponse createBoxOrder(CreateBoxOrderRequest request);

    /**
     * 查询订单列表
     *
     * @param request
     * @return
     */
    List<QueryBoxOrderResponse> queryBoxOrderList(QueryBoxOrderRequest request);
}
