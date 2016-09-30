package com.yeww.carbao.model.common;

import com.yeww.carbao.model.BaseEntity;

/**
 * Created by yeweiwei1 on 2016/8/10.
 */
public class VersionCodeEntity extends BaseEntity {

    private String versionCode;
    private String clientTypev;
    private String downloadUrl;
    private Integer forced;
    private String updateContent;

    public String getVersionCode() {
        return versionCode;
    }

    public void setVersionCode(String versionCode) {
        this.versionCode = versionCode;
    }

    public String getClientTypev() {
        return clientTypev;
    }

    public void setClientTypev(String clientTypev) {
        this.clientTypev = clientTypev;
    }

    public String getDownloadUrl() {
        return downloadUrl;
    }

    public void setDownloadUrl(String downloadUrl) {
        this.downloadUrl = downloadUrl;
    }

    public Integer getForced() {
        return forced;
    }

    public void setForced(Integer forced) {
        this.forced = forced;
    }

    public String getUpdateContent() {
        return updateContent;
    }

    public void setUpdateContent(String updateContent) {
        this.updateContent = updateContent;
    }
}
