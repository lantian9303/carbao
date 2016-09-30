package com.yeww.carbao.controller.common;

import com.yeww.carbao.domain.request.common.VerifyCodeRequest;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.service.common.IVerifyCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by yeweiwei1 on 2016/8/9.
 */
@Controller
@RequestMapping(value = "/common/verify/")
public class VerifyCodeController {

    private static final Logger Logs = LoggerFactory.getLogger(VerifyCodeController.class);

    @Resource
    private IVerifyCodeService verifyCodeService;

    @RequestMapping(value = "send-code")
    @ResponseBody
    public AppResponse sendVerifyCode(@RequestBody VerifyCodeRequest request) {
        AppResponse response=new AppResponse();
        try {
            verifyCodeService.sendVerifyCode(request);
            Logs.info("sentVerifyCode返回信息：", response);
        }catch (Exception e){
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
