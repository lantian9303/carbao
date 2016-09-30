package com.yeww.carbao.dao.box;

import com.yeww.carbao.model.box.BoxOrderEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/9/30.
 */
public interface BoxOrderMapper {
    Long insert(BoxOrderEntity entity);

    BoxOrderEntity selectById(Long id);

    void update(BoxOrderEntity carEntity);

    List<BoxOrderEntity> queryBoxOrderList(Map paramMap);
}
