package com.yeww.carbao.service.common.impl;

import com.yeww.carbao.dao.common.VersionCodeMapper;
import com.yeww.carbao.domain.request.common.VersionCodeQueryRequest;
import com.yeww.carbao.domain.response.common.VersionResponse;
import com.yeww.carbao.model.common.VersionCodeEntity;
import com.yeww.carbao.service.common.IVersionCodeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
@Service
public class VersionCodeServiceImpl implements IVersionCodeService {

    @Resource
    private VersionCodeMapper versionCodeMapper;

    @Override
    public VersionResponse checkUpdate(VersionCodeQueryRequest request) {
        VersionCodeEntity entity = versionCodeMapper.selectLastVersion(request.getType());
        if (entity == null) {
            return null;
        }
        VersionResponse response = new VersionResponse();
        if (entity.getVersionCode().equals(request.getVersion())) {//没有更新
            response.setVersion(entity.getVersionCode());
        } else {//最新的
            response.setVersion(entity.getVersionCode());
            response.setContent(entity.getUpdateContent());
            response.setIsUpdate(entity.getForced());
            response.setUrlAddress(entity.getDownloadUrl());
        }
        return response;
    }
}
