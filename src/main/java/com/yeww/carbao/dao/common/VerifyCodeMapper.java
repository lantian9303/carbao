package com.yeww.carbao.dao.common;

import com.yeww.carbao.model.common.VerifyCodeEntity;

/**
 * Created by yeweiwei1 on 2016/8/9.
 */
public interface VerifyCodeMapper {

    int insert(VerifyCodeEntity entity);

    VerifyCodeEntity selectById(long id);

    VerifyCodeEntity selectOne(VerifyCodeEntity entity);

    int update(VerifyCodeEntity entity);
}
