package com.yeww.carbao.model.car;

import com.yeww.carbao.model.BaseEntity;

/**
 * Created by yeweiwei1 on 2016/9/3.
 */
public class CarEntity extends BaseEntity{
    private Integer userId;//
    private Integer brandId;//品牌id
    private Integer seriesId;//车系id
    private String year;//年份
    private Integer typeId;//车型id
    private Integer boxId;//盒子id
    private String engineNo;//发动机号
    private String carNo;//车牌号
    private String frameNo;//车架号
    private String carImgUrl;//车架号

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public Integer getBrandId() {
        return brandId;
    }

    public void setBrandId(Integer brandId) {
        this.brandId = brandId;
    }

    public Integer getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(Integer seriesId) {
        this.seriesId = seriesId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getEngineNo() {
        return engineNo;
    }

    public void setEngineNo(String engineNo) {
        this.engineNo = engineNo;
    }

    public String getCarNo() {
        return carNo;
    }

    public void setCarNo(String carNo) {
        this.carNo = carNo;
    }

    public String getFrameNo() {
        return frameNo;
    }

    public void setFrameNo(String frameNo) {
        this.frameNo = frameNo;
    }

    public String getCarImgUrl() {
        return carImgUrl;
    }

    public void setCarImgUrl(String carImgUrl) {
        this.carImgUrl = carImgUrl;
    }

    public Integer getBoxId() {
        return boxId;
    }

    public void setBoxId(Integer boxId) {
        this.boxId = boxId;
    }

    @Override
    public String toString() {
        return "CarEntity{" +
                "userId=" + userId +
                ", brandId=" + brandId +
                ", seriesId=" + seriesId +
                ", year=" + year +
                ", typeId=" + typeId +
                ", engineNo=" + engineNo +
                ", carNo=" + carNo +
                ", frameNo=" + frameNo +
                ", boxId=" + boxId +
                ", carImgUrl=" + carImgUrl +
                '}';
    }
}
