package com.yeww.carbao.domain.response;

import com.yeww.carbao.domain.IConverter;

import java.io.Serializable;

/**
 * Created by yeweiwei1 on 2016/8/8.
 */
public class AppResponse<T> implements Serializable {
    /**
     * 000000 成功
     * 000001 失败
     */
    private String retcode = CodeEnum.SUCCESS.code;
    private String retinfo = CodeEnum.SUCCESS.message;
    private T data;

    public String getRetcode() {
        return retcode;
    }

    public void setRetcode(String retcode) {
        this.retcode = retcode;
    }

    public String getRetinfo() {
        return retinfo;
    }

    public void setRetinfo(String retinfo) {
        this.retinfo = retinfo;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setCodeError(CodeEnum codeEnum) {
        this.retcode = AppResponse.CodeEnum.ERROR.getCode();
        this.retinfo = AppResponse.CodeEnum.ERROR.getMessage();
    }

    public enum CodeEnum {
        SUCCESS("000000", "操作成功"), ERROR("000001", "系统错误");

        private String code;
        private String message;

        CodeEnum(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }
    }

    @Override
    public String toString() {
        return "AppResponse{" +
                "retcode='" + retcode + '\'' +
                ", retinfo='" + retinfo + '\'' +
                ", data=" + data +
                '}';
    }
}
