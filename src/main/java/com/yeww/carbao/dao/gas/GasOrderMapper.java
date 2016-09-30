package com.yeww.carbao.dao.gas;

import com.yeww.carbao.model.box.BoxOrderEntity;
import com.yeww.carbao.model.gas.GasOrderEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/9/30.
 */
public interface GasOrderMapper {
    Long insert(GasOrderEntity entity);

    GasOrderEntity selectById(Long id);

    void update(GasOrderEntity carEntity);

    List<GasOrderEntity> queryBoxOrderList(Map paramMap);
}
