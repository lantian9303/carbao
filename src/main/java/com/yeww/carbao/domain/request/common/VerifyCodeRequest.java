package com.yeww.carbao.domain.request.common;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/8/9.
 */
public class VerifyCodeRequest extends BaseRequest {
    private String clientType="phone";
    private String verifyType="user_register";
    private String phone;

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(String verifyType) {
        this.verifyType = verifyType;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "VerifyCodeRequest{" +
                "clientType='" + clientType + '\'' +
                ", verifyType='" + verifyType + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
