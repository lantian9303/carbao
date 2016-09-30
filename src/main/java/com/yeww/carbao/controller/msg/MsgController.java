package com.yeww.carbao.controller.msg;

import com.yeww.carbao.domain.request.msg.MsgQueryRequest;
import com.yeww.carbao.domain.request.msg.MsgSaveRequest;
import com.yeww.carbao.domain.request.msg.MsgWarnRequest;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.domain.response.msg.MsgQueryResponse;
import com.yeww.carbao.domain.response.msg.MsgWarnResponse;
import com.yeww.carbao.service.msg.IMsgService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/25.
 */
@Controller
@RequestMapping(value = "/msg/")
public class MsgController {

    private static final Logger Logs = LoggerFactory.getLogger(MsgController.class);

    @Resource
    private IMsgService msgService;

    /**
     * 保存
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "save")
    @ResponseBody
    public AppResponse save(@RequestBody MsgSaveRequest request) {
        Logs.info("save参数信息：", request);
        AppResponse response = new AppResponse();
        try {
            msgService.save(request);
            Logs.info("save返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }

    /**
     * 提醒
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "warn")
    @ResponseBody
    public AppResponse<MsgWarnResponse> warn(@RequestBody MsgWarnRequest request) {
        Logs.info("warn参数信息：", request);
        AppResponse<MsgWarnResponse> response = new AppResponse<MsgWarnResponse>();
        try {
            MsgWarnResponse msgWarnResponse = msgService.warn(request);
            response.setData(msgWarnResponse);
            Logs.info("warn返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
    /**
     * 查询
     *
     * @param request
     * @return
     */
    @RequestMapping(value = "query")
    @ResponseBody
    public AppResponse<List<MsgQueryResponse>> query(@RequestBody MsgQueryRequest request) {
        Logs.info("query参数信息：", request);
        AppResponse<List<MsgQueryResponse>> response = new AppResponse<List<MsgQueryResponse>>();
        try {
            List<MsgQueryResponse> responseList = msgService.query(request);
            response.setData(responseList);
            Logs.info("query返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
