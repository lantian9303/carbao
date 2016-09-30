package com.yeww.carbao.service.car.impl;

import com.yeww.carbao.dao.car.CarScopeMapper;
import com.yeww.carbao.domain.request.car.ScopeAddRequest;
import com.yeww.carbao.domain.request.car.ScopeQueryRequest;
import com.yeww.carbao.model.car.CarScopeEntity;
import com.yeww.carbao.service.car.ICarScopeService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
@Service
public class CarScopeServiceImpl implements ICarScopeService {
    @Resource
    private CarScopeMapper carScopeMapper;

    @Override
    public void add(ScopeAddRequest request) {
        CarScopeEntity entity = new CarScopeEntity();
        BeanUtils.copyProperties(request, entity);
        entity.setCreateTime(new Date());
        entity.setValid_sign("1");
        carScopeMapper.insert(entity);
    }

    @Override
    public List<CarScopeEntity> query(ScopeQueryRequest request) {
        Map paramMap = new HashMap();
        paramMap.put("userId", request.getUserId());
        paramMap.put("carId", request.getCarId());
        return carScopeMapper.selectList(paramMap);
    }
}
