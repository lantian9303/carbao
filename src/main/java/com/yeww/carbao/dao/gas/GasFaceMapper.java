package com.yeww.carbao.dao.gas;

import com.yeww.carbao.model.gas.GasFaceEntity;

import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public interface GasFaceMapper {

    List<GasFaceEntity> queryFace();

    GasFaceEntity selectById(Long id);
}
