package com.yeww.carbao.domain.request.vehicle;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/9/24.
 */
public class SubBrandQueryRequest extends BaseRequest {
    private String brandId;

    public String getBrandId() {
        return brandId;
    }

    public void setBrandId(String brandId) {
        this.brandId = brandId;
    }

    @Override
    public String toString() {
        return "SubBrandQueryRequest{" +
                "brandId=" + brandId +
                '}';
    }
}
