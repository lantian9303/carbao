package com.yeww.carbao.service.car;

import com.yeww.carbao.domain.request.car.CarQueryRequest;
import com.yeww.carbao.domain.request.car.CarUpdateRequest;
import com.yeww.carbao.model.car.CarEntity;

/**
 * Created by yeweiwei1 on 2016/9/24.
 */
public interface ICarService {
    /**
     * 更新爱车信息
     *
     * @param request
     */
    void save(CarUpdateRequest request);

    /**
     * 查询
     *
     * @param request
     * @return
     */
    CarEntity query(CarQueryRequest request);
}
