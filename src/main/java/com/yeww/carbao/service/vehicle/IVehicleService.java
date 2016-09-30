package com.yeww.carbao.service.vehicle;

import com.yeww.carbao.domain.request.vehicle.BrandQueryRequest;
import com.yeww.carbao.domain.request.vehicle.CarTypeQueryRequest;
import com.yeww.carbao.domain.request.vehicle.SubBrandQueryRequest;
import com.yeww.carbao.domain.request.vehicle.YearQueryRequest;
import com.yeww.carbao.domain.response.vehicle.BrandQueryResponse;
import com.yeww.carbao.domain.response.vehicle.CarTypeQueryResponse;
import com.yeww.carbao.domain.response.vehicle.SubBrandQueryResponse;
import com.yeww.carbao.domain.response.vehicle.YearQueryResponse;

import java.util.List;

/**
 * Created by yeweiwei1 on 2016/8/17.
 */
public interface IVehicleService {
    /**
     * 品牌查询
     *
     * @param request
     * @return
     */
    List<BrandQueryResponse> brandQuery(BrandQueryRequest request);

    /**
     * 车系查询
     *
     * @param request
     * @return
     */
    List<SubBrandQueryResponse> subBrandQuery(SubBrandQueryRequest request);

    /**
     * 年份查询
     *
     * @param request
     * @return
     */
    List<YearQueryResponse> yearQuery(YearQueryRequest request);

    /**
     * 车型查询
     * @param request
     * @return
     */
    List<CarTypeQueryResponse> carTypeQuery(CarTypeQueryRequest request);
}
