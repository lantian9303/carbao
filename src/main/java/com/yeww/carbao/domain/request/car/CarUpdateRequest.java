package com.yeww.carbao.domain.request.car;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/9/24.
 */
public class CarUpdateRequest extends BaseRequest {
    private Long carId;
    private Integer brandId;
    private Integer seriesId;
    private String year;
    private Integer typeId;
    private String engineNo;
    private String carNo;
    private String frameNo;
    private String carImgUrl;

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
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

    @Override
    public String toString() {
        return "CarUpdateRequest{" +
                "carId='" + carId + '\'' +
                ", brandId='" + brandId + '\'' +
                ", seriesId='" + seriesId + '\'' +
                ", year='" + year + '\'' +
                ", typeId='" + typeId + '\'' +
                ", engineNo='" + engineNo + '\'' +
                ", carNo='" + carNo + '\'' +
                ", frameNo='" + frameNo + '\'' +
                ", carImgUrl='" + carImgUrl + '\'' +
                '}';
    }
}
