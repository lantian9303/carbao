package com.yeww.carbao.utils;

/**
 * Created by yeweiwei1 on 2016/8/9.
 */
public class AppException extends Exception {

    private String code;
    private String errorDesc;
    private Throwable cause;

    public AppException(String code, String errorDesc, Throwable cause) {
        super(errorDesc, cause);
        this.errorDesc = errorDesc;
        this.code = code;
        this.cause = cause;
    }

    public AppException(String code, String errorDesc) {
        super(errorDesc);
        this.errorDesc = errorDesc;
        this.code = code;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getErrorDesc() {
        return errorDesc;
    }

    public void setErrorDesc(String errorDesc) {
        this.errorDesc = errorDesc;
    }

    @Override
    public String toString() {
        return "APPException{" +
                "code='" + code + '\'' +
                ", errorDesc='" + errorDesc + '\'' +
                ", cause='" + cause + '\'' +
                '}';
    }
}
