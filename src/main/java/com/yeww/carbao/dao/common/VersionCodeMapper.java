package com.yeww.carbao.dao.common;

import com.yeww.carbao.model.common.VersionCodeEntity;

/**
 * Created by yeweiwei1 on 2016/8/10.
 */
public interface VersionCodeMapper {

    int insert(VersionCodeEntity entity);

    VersionCodeEntity selectById(Long id);

    VersionCodeEntity selectLastVersion(String type);
}
