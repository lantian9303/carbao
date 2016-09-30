package com.yeww.carbao.service.common;

import com.yeww.carbao.domain.enums.SmsTemplateEnum;

import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/7.
 */
public interface ISmsService {
    String sendSns(String mobile, SmsTemplateEnum smsTemplateEnum, List<String> list);
}
