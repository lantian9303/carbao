package com.yeww.carbao.domain.response.box;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.box.BoxOrderEntity;

/**
 * Created by yeweiwei1 on 2016/9/30.
 */
public class CreateBoxOrderResponse extends BaseResponse<BoxOrderEntity> {

    private String orderNo;

    @Override
    public void converter(BoxOrderEntity boxOrderEntity) {
        this.orderNo=boxOrderEntity.getOrderNum();
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }
}
