package com.yeww.carbao.domain.response.common;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.common.AdvertisementEntity;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public class AdvertisementRespnse extends BaseResponse<AdvertisementEntity> {

    private Long adId;
    private String title;
    private String adImg;
    private String adHtml;

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

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

    @Override
    public void converter(AdvertisementEntity advertisementEntity) {
        this.adId = advertisementEntity.getId();
        this.title = advertisementEntity.getTitle();
        this.adHtml = advertisementEntity.getAdHtml();
        this.adImg = advertisementEntity.getAdImg();
    }

    @Override
    public String toString() {
        return "AdvertisementRespnse{" +
                "adId='" + adId + '\'' +
                ", title='" + title + '\'' +
                ", adImg='" + adImg + '\'' +
                ", adHtml='" + adHtml + '\'' +
                '}';
    }
}
