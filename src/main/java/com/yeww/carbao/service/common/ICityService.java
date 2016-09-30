package com.yeww.carbao.service.common;

import com.yeww.carbao.domain.response.common.CityQueryResponse;
import com.yeww.carbao.model.common.CityEntiity;

import java.util.List;

/**
 * Created by yeweiwei1 on 2016/8/8.
 */
public interface ICityService {
    void init();

    List<CityQueryResponse> getCityInfo();

    CityEntiity selectById(Long id);
}
