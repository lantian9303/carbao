package com.yeww.carbao.controller.common;

import com.yeww.carbao.domain.request.common.VersionCodeQueryRequest;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.domain.response.common.VersionResponse;
import com.yeww.carbao.service.common.IVersionCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by yeweiwei1 on 2016/8/10.
 */
@Controller
@RequestMapping(value = "/common/version/")
public class VersionCodeController {

    private static final Logger Logs = LoggerFactory.getLogger(VersionCodeController.class);

    @Resource
    private IVersionCodeService versionCodeService;

    @RequestMapping(value = "check")
    @ResponseBody
    public AppResponse<VersionResponse> checkUpdate(@RequestBody VersionCodeQueryRequest request) {
        Logs.info("checkUpdate参数信息：", request);
        AppResponse<VersionResponse> response = new AppResponse<VersionResponse>();
        try {
            VersionResponse response1 = versionCodeService.checkUpdate(request);
            response.setData(response1);
            Logs.info("checkUpdate返回信息："+ response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
