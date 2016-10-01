package com.yeww.carbao.dao.common;

import com.yeww.carbao.model.common.VersionCodeEntity;

/**
 * Created by yeweiwei1 on 2016/8/10.
 */
public interface VersionCodeMapper {

    Integer insert(VersionCodeEntity entity);

    VersionCodeEntity selectById(Long id);

    VersionCodeEntity selectLastVersion(String type);
}
