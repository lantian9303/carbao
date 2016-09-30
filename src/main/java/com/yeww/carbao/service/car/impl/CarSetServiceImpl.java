package com.yeww.carbao.service.car.impl;

import com.yeww.carbao.dao.car.CarSetMapper;
import com.yeww.carbao.domain.request.car.WarnQueryRequest;
import com.yeww.carbao.domain.request.car.VoltageSetRequest;
import com.yeww.carbao.domain.request.car.WarnSetRequest;
import com.yeww.carbao.model.car.CarSetEntity;
import com.yeww.carbao.service.car.ICarSetService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
@Service
public class CarSetServiceImpl implements ICarSetService {

    @Resource
    private CarSetMapper carSetMapper;


    @Override
    public void setVoltage(VoltageSetRequest request) {
        Map paramMap = new HashMap(2);
        paramMap.put("carId", request.getCarId());
        paramMap.put("userId", request.getUserId());
        CarSetEntity entity = carSetMapper.selectOne(paramMap);
        if (entity == null) {
            //insert
            entity = new CarSetEntity();
            entity.setUserId(request.getUserId());
            entity.setCarId(request.getCarId());
            entity.setVoltage(request.getVoltage());
            entity.setCreateTime(new Date());
            carSetMapper.insert(entity);
        } else {
            //update
            entity.setVoltage(request.getVoltage());
            carSetMapper.update(entity);
        }
    }

    @Override
    public void setWarn(WarnSetRequest request) {
        Map paramMap = new HashMap(2);
        paramMap.put("carId", request.getCarId());
        paramMap.put("userId", request.getUserId());
        CarSetEntity entity = carSetMapper.selectOne(paramMap);
        if (entity == null) {
            //insert
            entity = new CarSetEntity();
            entity.setUserId(request.getUserId());
            entity.setCarId(request.getCarId());
            entity.setOver_speed(request.getOverSpeed());
            entity.setScope(request.getScope());
            entity.setStart(request.getStart());
            entity.setShake(request.getShake());
            entity.setCreateTime(new Date());
            carSetMapper.insert(entity);
        } else {
            //update
            entity.setOver_speed(request.getOverSpeed());
            entity.setScope(request.getScope());
            entity.setStart(request.getStart());
            entity.setShake(request.getShake());
            carSetMapper.update(entity);
        }
    }

    @Override
    public CarSetEntity queryWarn(WarnQueryRequest request) {
        Map paramMap = new HashMap(2);
        paramMap.put("carId", request.getCarId());
        paramMap.put("userId", request.getUserId());
        return carSetMapper.selectOne(paramMap);
    }
}
