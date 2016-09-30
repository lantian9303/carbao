package com.carbao.service;

import com.BaseTest;
import com.yeww.carbao.domain.enums.SmsTemplateEnum;
import com.yeww.carbao.service.common.ISmsService;
import org.junit.Test;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/9.
 */
public class SmsServiceTest extends BaseTest {
    @Resource
    private ISmsService smsService;

    @Test
    public void sns(){
        String content="【车宝网】您的验证码是@123456，有效时间1分钟，请不要告诉他人";
        List verifyList=new ArrayList();
        verifyList.add("12345");
        System.out.println(smsService.sendSns("18626410828", SmsTemplateEnum.user_register,verifyList));
    }
}
