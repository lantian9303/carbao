package com.yeww.carbao.model.common;

import com.yeww.carbao.model.BaseEntity;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public class AdvertisementEntity extends BaseEntity {
    private String title;
    private String adImg;
    private String adHtml;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdImg() {
        return adImg;
    }

    public void setAdImg(String adImg) {
        this.adImg = adImg;
    }

    public String getAdHtml() {
        return adHtml;
    }

    public void setAdHtml(String adHtml) {
        this.adHtml = adHtml;
    }
}
