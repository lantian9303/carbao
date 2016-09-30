package com.yeww.carbao.domain.request.box;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/9/30.
 */
public class CreateBoxOrderRequest extends BaseRequest {
    private Long boxId;

    public Long getBoxId() {
        return boxId;
    }

    public void setBoxId(Long boxId) {
        this.boxId = boxId;
    }
}
