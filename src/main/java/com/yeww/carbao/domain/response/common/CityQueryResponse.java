package com.yeww.carbao.domain.response.common;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.common.CityEntiity;

/**
 * Created by yeweiwei1 on 2016/8/8.
 */
public class CityQueryResponse extends BaseResponse<CityEntiity> {
    private Long cityId;
    private String name;
    private String type;

    public Long getCityId() {
        return cityId;
    }

    public void setCityId(Long cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void converter(CityEntiity cityEntiity) {
        this.cityId = cityEntiity.getId();
        this.name = cityEntiity.getCityName();
        this.type = cityEntiity.getCityZh().toUpperCase().substring(0, 1);
    }
}
