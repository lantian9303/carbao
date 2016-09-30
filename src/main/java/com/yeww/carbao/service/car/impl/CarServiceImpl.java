package com.yeww.carbao.service.car.impl;

import com.yeww.carbao.dao.car.CarMapper;
import com.yeww.carbao.domain.request.car.CarQueryRequest;
import com.yeww.carbao.domain.request.car.CarUpdateRequest;
import com.yeww.carbao.model.car.CarEntity;
import com.yeww.carbao.service.car.ICarService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/9/24.
 */
@Service
public class CarServiceImpl implements ICarService {

    @Resource
    private CarMapper carMapper;

    /**
     * 更新爱车信息
     *
     * @param request
     */
    @Override
    public void save(CarUpdateRequest request) {

        Map paramMap = new HashMap();
        paramMap.put("userId", request.getUserId());
        paramMap.put("carId", request.getUserId());
        paramMap.put("brandId", request.getUserId());
        paramMap.put("seriesId", request.getUserId());
        paramMap.put("brandId", request.getUserId());
        paramMap.put("brandId", request.getUserId());
        CarEntity carEntity = carMapper.selectById(request.getCarId());
        if (carEntity == null) {
            CarEntity entity = new CarEntity();
            entity.setCreateTime(new Date());
            entity.setModifyTime(entity.getCreateTime());
            entity.setBrandId(request.getBrandId());
            entity.setSeriesId(request.getSeriesId());
            entity.setCarNo(request.getCarNo());
            entity.setYear(request.getYear());
            entity.setEngineNo(request.getEngineNo());
            entity.setFrameNo(request.getFrameNo());
            entity.setCarImgUrl(request.getCarImgUrl());
            carMapper.insert(entity);
        } else {
            carEntity.setBrandId(request.getBrandId());
            carEntity.setSeriesId(request.getSeriesId());
            carEntity.setCarNo(request.getCarNo());
            carEntity.setYear(request.getYear());
            carEntity.setEngineNo(request.getEngineNo());
            carEntity.setFrameNo(request.getFrameNo());
            carEntity.setCarImgUrl(request.getCarImgUrl());
            carEntity.setId(request.getCarId());
            carMapper.update(carEntity);
        }
    }

    /**
     * 查询
     *
     * @param request
     * @return
     */
    @Override
    public CarEntity query(CarQueryRequest request) {
        return carMapper.selectById(request.getCarId());
    }
}
