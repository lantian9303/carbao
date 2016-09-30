package com.yeww.carbao.dao.msg;

import com.yeww.carbao.model.msg.MsgEntity;

import java.util.List;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/9/6.
 */
public interface MsgMapper {

    Long insert(MsgEntity entity);

    MsgEntity selectById(Long id);

    List<MsgEntity> selectList(Map paramsMap);

    void update(MsgEntity carEntity);
}
