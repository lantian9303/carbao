package com.yeww.carbao.service.vehicle.impl;

import com.yeww.carbao.dao.vehicle.CarInfoMapper;
import com.yeww.carbao.dao.vehicle.VehicleBrandMapper;
import com.yeww.carbao.dao.vehicle.VehicleSubBrandMapper;
import com.yeww.carbao.domain.request.vehicle.BrandQueryRequest;
import com.yeww.carbao.domain.request.vehicle.CarTypeQueryRequest;
import com.yeww.carbao.domain.request.vehicle.SubBrandQueryRequest;
import com.yeww.carbao.domain.request.vehicle.YearQueryRequest;
import com.yeww.carbao.domain.response.vehicle.BrandQueryResponse;
import com.yeww.carbao.domain.response.vehicle.CarTypeQueryResponse;
import com.yeww.carbao.domain.response.vehicle.SubBrandQueryResponse;
import com.yeww.carbao.domain.response.vehicle.YearQueryResponse;
import com.yeww.carbao.model.vehicle.CarInfoEntity;
import com.yeww.carbao.model.vehicle.VehicleBrandEntity;
import com.yeww.carbao.model.vehicle.VehicleSubBrandEntity;
import com.yeww.carbao.service.vehicle.IVehicleService;
import com.yeww.carbao.utils.HttpClientUtil;
import com.yeww.carbao.utils.JsonUtil;
import com.yeww.carbao.utils.StringUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by yeweiwei1 on 2016/8/17.
 */
@Service
public class VehicleServiceImpl implements IVehicleService {

    @Resource
    private VehicleBrandMapper vehicleBrandMapper;

    @Resource
    private VehicleSubBrandMapper vehicleSubBrandMapper;

    @Resource
    private CarInfoMapper carInfoMapper;

    @Value("${vehicle_car_query_host}")
    private String vehicle_car_query_host;

    @Value("${vehicle_brand_query_host}")
    private String vehicle_brand_query_host;

    @Value("${vehicle_system_query_key}")
    private String vehicle_system_query_key;

    /**
     * 品牌查询
     *
     * @param request
     * @return
     */
    @Override
    public List<BrandQueryResponse> brandQuery(BrandQueryRequest request) {
        List<VehicleBrandEntity> vehicleBrandEntityList = vehicleBrandMapper.selectAll();
        if (CollectionUtils.isEmpty(vehicleBrandEntityList)) {
            return null;
        }
        List<BrandQueryResponse> responseList = new ArrayList<BrandQueryResponse>(vehicleBrandEntityList.size());
        for (VehicleBrandEntity entity : vehicleBrandEntityList) {
            BrandQueryResponse response = new BrandQueryResponse();
            response.converter(entity);
            responseList.add(response);
        }
        return responseList;
    }

    /**
     * 车系查询
     *
     * @param request
     * @return
     */
    @Override
    public List<SubBrandQueryResponse> subBrandQuery(SubBrandQueryRequest request) {
        VehicleBrandEntity brandEntity = vehicleBrandMapper.selectById(Long.parseLong(request.getBrandId()));
        if (brandEntity == null) {
            return null;
        }
        List<VehicleSubBrandEntity> subBrandEntityList = vehicleSubBrandMapper.selectByBrandId(Long.parseLong(request.getBrandId()));
        if (CollectionUtils.isEmpty(subBrandEntityList)) {//列表为空  去聚合查询并持久化到数据库中
            Map<String, Object> paramMap = new HashMap<String, Object>(2);
            paramMap.put("key", vehicle_system_query_key);
            paramMap.put("brand", brandEntity.getName());
            String response = HttpClientUtil.get(vehicle_brand_query_host, paramMap);
            if (StringUtil.isEmpty(response)) {
                return null;
            }

            Map returnMap = JsonUtil.toMap(response);
            if (returnMap == null || (Integer) returnMap.get("error_code") != 0) {
                return null;
            }
            List<Map> list = (List<Map>) JsonUtil.getNodeValue(returnMap, "result");
            if (CollectionUtils.isEmpty(list)) {
                return null;
            }
            for (Map map : list) {
                VehicleSubBrandEntity subBrandEntity = new VehicleSubBrandEntity();
                subBrandEntity.setCreateTime(new Date());
                subBrandEntity.setModifyTime(subBrandEntity.getCreateTime());
                subBrandEntity.setBrandId(Long.parseLong(request.getBrandId()));
                subBrandEntity.setBrandName(brandEntity.getName());
                subBrandEntity.setComName((String) map.get("car"));
                subBrandEntity.setSubBrandName((String) map.get("type"));
                vehicleSubBrandMapper.insert(subBrandEntity);
            }
        }

        List<VehicleSubBrandEntity> temList = vehicleSubBrandMapper.selectByBrandId(Long.parseLong(request.getBrandId()));
        if (CollectionUtils.isEmpty(temList)) {
            return null;
        }
        List<SubBrandQueryResponse> responseList = new ArrayList<SubBrandQueryResponse>();
        for (VehicleSubBrandEntity entity : temList) {
            SubBrandQueryResponse response = new SubBrandQueryResponse();
            response.converter(entity);
            responseList.add(response);
        }
        return responseList;
    }

    /**
     * 年份查询
     *
     * @param request
     * @return
     */
    @Override
    public List<YearQueryResponse> yearQuery(YearQueryRequest request) {
        VehicleSubBrandEntity subBrandEntity = vehicleSubBrandMapper.selectById(Long.parseLong(request.getSeriesId()));
        if (subBrandEntity == null) {
            return null;
        }
        List<CarInfoEntity> carInfoEntityList = carInfoMapper.selectBySubBrandId(subBrandEntity.getId());
        if (CollectionUtils.isEmpty(carInfoEntityList)) {//列表为空  去聚合查询并持久化到数据库中
            Map<String, Object> paramMap = new HashMap<String, Object>(2);
            paramMap.put("key", vehicle_system_query_key);
            paramMap.put("car", subBrandEntity.getSubBrandName());
            String response = HttpClientUtil.get(vehicle_car_query_host, paramMap);
            if (StringUtil.isEmpty(response)) {
                return null;
            }

            Map returnMap = JsonUtil.toMap(response);
            if (returnMap == null || (Integer) returnMap.get("error_code") != 0) {
                return null;
            }
            /*List<Map> carinfoMap = (List<Map>) JsonUtil.getNodeValue(returnMap, "result/carinfo");
            String carType= (String) carinfoMap.get("级别");*/
            List<Map> carsMapList = (List<Map>) JsonUtil.getNodeValue(returnMap, "result/auto_series_info/cars");
            if(CollectionUtils.isEmpty(carsMapList)){
                return null;
            }
            for(Map map:carsMapList){
                List<Map> carMap= (List<Map>) map.get("car");
                for(Map m :carMap){
                    CarInfoEntity entity=new CarInfoEntity();
                    entity.setCreateTime(new Date());
                    entity.setModifyTime(entity.getCreateTime());
                    entity.setBrandId(subBrandEntity.getBrandId());
                    entity.setSubBrandId(subBrandEntity.getId());
                    entity.setCarType("");
                    entity.setName((String) m.get("name"));
                    entity.setTrans((String) m.get("trans"));
                    entity.setYear(entity.getName().substring(0,4));
                    carInfoMapper.insert(entity);
                }
            }
        }

        List<CarInfoEntity> temList = carInfoMapper.selectBySubBrandId(subBrandEntity.getId());
        if (CollectionUtils.isEmpty(temList)) {
            return null;
        }
        List<YearQueryResponse> responseList = new ArrayList<YearQueryResponse>();
        for (CarInfoEntity entity : temList) {
            YearQueryResponse response = new YearQueryResponse();
            response.converter(entity);
            responseList.add(response);
        }
        return responseList;
    }

    /**
     * 车型查询
     *
     * @param request
     * @return
     */
    @Override
    public List<CarTypeQueryResponse> carTypeQuery(CarTypeQueryRequest request) {
        Map paramMap=new HashMap();
        paramMap.put("subBrandId",request.getSeriesId());
        paramMap.put("year",request.getYear());
        List<CarInfoEntity> temList = carInfoMapper.selectByMap(paramMap);
        if(CollectionUtils.isEmpty(temList)){
            return null;
        }
        List<CarTypeQueryResponse> responseList=new ArrayList<CarTypeQueryResponse>(temList.size());
        for (CarInfoEntity entity : temList) {
            CarTypeQueryResponse response = new CarTypeQueryResponse();
            response.converter(entity);
            responseList.add(response);
        }
        return responseList;
    }
}
