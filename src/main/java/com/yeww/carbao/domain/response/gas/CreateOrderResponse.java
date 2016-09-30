package com.yeww.carbao.domain.response.gas;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.gas.GasOrderEntity;

/**
 * Created by yeweiwei1 on 2016/9/30.
 */
public class CreateOrderResponse extends BaseResponse<GasOrderEntity> {

    private String orderNo;

    @Override
    public void converter(GasOrderEntity gasOrderEntity) {
        this.orderNo=gasOrderEntity.getOrderNum();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
