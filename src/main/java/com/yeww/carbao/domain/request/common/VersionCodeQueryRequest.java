package com.yeww.carbao.domain.request.common;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public class VersionCodeQueryRequest extends BaseRequest {
    private String version;
    /**
     * 0  安卓
     * 1  苹果
     */
    private String type;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "VersionCodeQueryRequest{" +
                "version='" + version + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
