package com.yeww.carbao.dao.common;

import com.yeww.carbao.model.common.CityEntiity;

import java.util.List;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/8/8.
 */
public interface CityMapper {
    Integer insert(CityEntiity cityEntiity);

    List<CityEntiity> selectAll(Map param);

    CityEntiity selectById(Long id);
}
