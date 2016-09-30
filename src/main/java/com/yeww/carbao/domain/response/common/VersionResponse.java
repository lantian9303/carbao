package com.yeww.carbao.domain.response.common;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.common.VersionCodeEntity;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public class VersionResponse extends BaseResponse<VersionCodeEntity> {
    private String version;
    private String content;
    private Integer isUpdate;
    private String urlAddress;

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getIsUpdate() {
        return isUpdate;
    }

    public void setIsUpdate(Integer isUpdate) {
        this.isUpdate = isUpdate;
    }

    public String getUrlAddress() {
        return urlAddress;
    }

    public void setUrlAddress(String urlAddress) {
        this.urlAddress = urlAddress;
    }
}
