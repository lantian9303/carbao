package com.yeww.carbao.service.car;

import com.yeww.carbao.domain.request.car.ScopeAddRequest;
import com.yeww.carbao.domain.request.car.ScopeQueryRequest;
import com.yeww.carbao.model.car.CarScopeEntity;

import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public interface ICarScopeService {
    void add(ScopeAddRequest request);

    List<CarScopeEntity> query(ScopeQueryRequest request);
}
