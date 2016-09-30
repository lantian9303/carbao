package com.yeww.carbao.model.common;

import com.yeww.carbao.model.BaseEntity;

/**
 * Created by yeweiwei1 on 2016/8/9.
 */
public class VerifyCodeEntity extends BaseEntity {

    private String verifyCode;
    /**
     * 验证类别
     */
    private String verifyType;
    /**
     * 接口验证码客户端类型
     * phone.email
     */
    private String clientType;
    private String clientCode;
    private Integer validSign;

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getVerifyType() {
        return verifyType;
    }

    public void setVerifyType(String verifyType) {
        this.verifyType = verifyType;
    }

    public String getClientType() {
        return clientType;
    }

    public void setClientType(String clientType) {
        this.clientType = clientType;
    }

    public String getClientCode() {
        return clientCode;
    }

    public void setClientCode(String clientCode) {
        this.clientCode = clientCode;
    }

    public Integer getValidSign() {
        return validSign;
    }

    public void setValidSign(Integer validSign) {
        this.validSign = validSign;
    }

    public enum VerifyTypeEnum {
        recover_password, user_register
    }
}
