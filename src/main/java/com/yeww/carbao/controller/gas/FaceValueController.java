package com.yeww.carbao.controller.gas;

import com.yeww.carbao.domain.request.gas.FaceValueRequest;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.domain.response.gas.FaceValueResponse;
import com.yeww.carbao.service.gas.IGasFaceService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
@Controller
@RequestMapping(value = "/gas/face/")
public class FaceValueController {

    private static final Logger Logs = LoggerFactory.getLogger(FaceValueController.class);
    @Resource
    private IGasFaceService gasFaceService;

    @RequestMapping(value = "query")
    @ResponseBody
    public AppResponse queryFace(@RequestBody FaceValueRequest request) {
        Logs.info("queryFace参数信息：", request);
        AppResponse<List<FaceValueResponse>> response = new AppResponse<List<FaceValueResponse>>();
        try {
            List<FaceValueResponse> carSetEntity = gasFaceService.queryFace(request);
            response.setData(carSetEntity);
            Logs.info("queryFace返回信息：", response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
