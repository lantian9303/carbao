package com.yeww.carbao.controller.common;

import com.yeww.carbao.domain.request.common.UploadRequest;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.service.common.IUploadService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/9/12.
 */
@Controller
@RequestMapping(value = "/common/")
public class FileUploadController {

    private static final Logger Logs = LoggerFactory.getLogger(FileUploadController.class);

    @Resource
    private IUploadService uploadService;

    /**
     * \
     * 上传文件
     *
     * @return
     */
    @RequestMapping(value = "upload")
    @ResponseBody
    public AppResponse upload(HttpServletRequest request) {
        Logs.info("upload参数信息：", request);
        AppResponse response = new AppResponse();
        try {
            String url=uploadService.upload(request);
            Map map=new HashMap();
            map.put("url",url);
            response.setData(map);
            Logs.info("upload返回信息：", response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
