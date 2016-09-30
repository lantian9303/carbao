package com.yeww.carbao.service.car;

import com.yeww.carbao.domain.request.car.WarnQueryRequest;
import com.yeww.carbao.domain.request.car.VoltageSetRequest;
import com.yeww.carbao.domain.request.car.WarnSetRequest;
import com.yeww.carbao.model.car.CarSetEntity;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public interface ICarSetService {

    void setVoltage(VoltageSetRequest request);

    void setWarn(WarnSetRequest request);

    CarSetEntity queryWarn(WarnQueryRequest request);
}
