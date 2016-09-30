package com.yeww.carbao.dao.box;

import com.yeww.carbao.model.box.BoxEntity;

/**
 * Created by yeweiwei1 on 2016/9/30.
 */
public interface BoxMapper {
    Long insert(BoxEntity entity);

    BoxEntity selectById(Long id);

    void update(BoxEntity carEntity);
}
