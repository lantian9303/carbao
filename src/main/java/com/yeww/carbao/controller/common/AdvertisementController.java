package com.yeww.carbao.controller.common;

import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.domain.response.common.AdvertisementRespnse;
import com.yeww.carbao.service.common.IAdvertisementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
@Controller
@RequestMapping(value = "/common/adver/")
public class AdvertisementController {

    private static final Logger Logs = LoggerFactory.getLogger(AdvertisementController.class);

    @Resource
    private IAdvertisementService advertisementService;

    @RequestMapping(value = "query")
    @ResponseBody
    public AppResponse<List<AdvertisementRespnse>> query() {

        Logs.info("query参数信息：");
        AppResponse<List<AdvertisementRespnse>> response = new AppResponse<List<AdvertisementRespnse>>();
        try {
            List<AdvertisementRespnse> carSetEntity = advertisementService.queryList();
            response.setData(carSetEntity);
            Logs.info("query返回信息：" + response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
