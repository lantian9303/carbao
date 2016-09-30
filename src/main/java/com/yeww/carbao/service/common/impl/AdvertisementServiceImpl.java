package com.yeww.carbao.service.common.impl;

import com.yeww.carbao.dao.common.AdvertisementMapper;
import com.yeww.carbao.domain.response.common.AdvertisementRespnse;
import com.yeww.carbao.model.common.AdvertisementEntity;
import com.yeww.carbao.service.common.IAdvertisementService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
@Service
public class AdvertisementServiceImpl implements IAdvertisementService {

    @Resource
    private AdvertisementMapper advertisementMapper;

    @Override
    public List<AdvertisementRespnse> queryList() {
        List<AdvertisementEntity> advertisementEntityList = advertisementMapper.queryList();
        if(CollectionUtils.isEmpty(advertisementEntityList)){
            return null;
        }
        List<AdvertisementRespnse> respnseList=new ArrayList<AdvertisementRespnse>();
        for (AdvertisementEntity entity :advertisementEntityList){
            AdvertisementRespnse respnse=new AdvertisementRespnse();
            respnse.converter(entity);
            respnseList.add(respnse);
        }
        return respnseList;
    }
}
