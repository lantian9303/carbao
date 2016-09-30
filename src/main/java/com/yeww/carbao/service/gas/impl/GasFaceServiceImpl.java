package com.yeww.carbao.service.gas.impl;

import com.yeww.carbao.dao.gas.GasFaceMapper;
import com.yeww.carbao.domain.request.gas.FaceValueRequest;
import com.yeww.carbao.domain.response.gas.FaceValueResponse;
import com.yeww.carbao.model.gas.GasFaceEntity;
import com.yeww.carbao.service.gas.IGasFaceService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
@Service
public class GasFaceServiceImpl implements IGasFaceService {

    @Resource
    private GasFaceMapper gasFaceMapper;

    @Override
    public List<FaceValueResponse> queryFace(FaceValueRequest request) {
        List<GasFaceEntity> entityList = gasFaceMapper.queryFace();
        if(CollectionUtils.isEmpty(entityList)){
            return null;
        }
        List<FaceValueResponse> responseList=new ArrayList<FaceValueResponse>();
        for(GasFaceEntity entity :entityList){
            FaceValueResponse response=new FaceValueResponse();
            response.converter(entity);
            responseList.add(response);
        }
        return responseList;
    }
}
