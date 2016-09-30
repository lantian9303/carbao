package com.yeww.carbao.service.msg;

import com.yeww.carbao.domain.request.msg.MsgQueryRequest;
import com.yeww.carbao.domain.request.msg.MsgSaveRequest;
import com.yeww.carbao.domain.request.msg.MsgWarnRequest;
import com.yeww.carbao.domain.response.msg.MsgQueryResponse;
import com.yeww.carbao.domain.response.msg.MsgWarnResponse;

import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/25.
 */
public interface IMsgService {
    /**
     * 消息保存
     *
     * @param request
     */
    void save(MsgSaveRequest request);

    /**
     * 消息提醒
     *
     * @param request
     */
    MsgWarnResponse warn(MsgWarnRequest request);

    /**
     * 消息查询
     *
     * @param request
     * @return
     */
    List<MsgQueryResponse> query(MsgQueryRequest request);
}
