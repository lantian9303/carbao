package com.yeww.carbao.domain.enums;

/**
 * Created by yeweiwei1 on 2016/9/9.
 */
public enum  SmsTemplateEnum {
    user_register("【车宝网】您的验证码是{1}，有效时间1分钟，请不要告诉他人");

    private String template;

    SmsTemplateEnum(String template) {
        this.template = template;
    }

    public String getTemplate() {
        return template;
    }
}
