package com.yeww.carbao.domain.response.msg;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.msg.MsgEntity;

/**
 * Created by yeweiwei1 on 2016/9/25.
 */
public class MsgWarnResponse extends BaseResponse<MsgEntity> {
    private Integer flag;

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "MsgWarnResponse{" +
                "flag=" + flag +
                '}';
    }
}
