package com.yeww.carbao.domain.request;

import java.io.Serializable;

/**
 * Created by yeweiwei1 on 2016/8/8.
 */
public class BaseRequest implements Serializable {

    private String userId;;

    /**
     * 加密:simple
     * 不加密:none
     */
    private String encrypt;

    public String getEncrypt() {
        return encrypt;
    }

    public void setEncrypt(String encrypt) {
        this.encrypt = encrypt;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "BaseRequest{" +
                "encrypt='" + encrypt + '\'' +
                "userId='" + userId + '\'' +
                '}';
    }
}
