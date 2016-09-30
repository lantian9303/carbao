package com.yeww.carbao.service.common;

import com.yeww.carbao.domain.request.common.VerifyCodeRequest;

/**
 * Created by yeweiwei1 on 2016/8/9.
 */
public interface IVerifyCodeService {
    /**
     * 发送验证码
     *
     * @param request
     */
    void sendVerifyCode(VerifyCodeRequest request);

    /**
     * 验证码是否有效
     *
     * @param verifyCode
     * @param clientType
     * @param clientCode
     * @param verifyType
     * @return
     */
    boolean haveEffective(String verifyCode, String clientType, String clientCode, String verifyType);
}
