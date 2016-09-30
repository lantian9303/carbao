package com.yeww.carbao.domain.request.vehicle;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/9/24.
 */
public class YearQueryRequest extends BaseRequest {
    private String brandId;
    private String seriesId;

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

    @Override
    public String toString() {
        return "SubBrandQueryRequest{" +
                "brandId=" + brandId +
                "seriesId=" + seriesId +
                '}';
    }
}
