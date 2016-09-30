package com.yeww.carbao.domain.request.vehicle;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/9/24.
 */
public class CarTypeQueryRequest extends BaseRequest {
    private String brandId;
    private String seriesId;
    private String year;

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    public String getSeriesId() {
        return seriesId;
    }

    public void setSeriesId(String seriesId) {
        this.seriesId = seriesId;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return "SubBrandQueryRequest{" +
                "brandId=" + brandId +
                "year=" + year +
                "seriesId=" + seriesId +
                '}';
    }
}
