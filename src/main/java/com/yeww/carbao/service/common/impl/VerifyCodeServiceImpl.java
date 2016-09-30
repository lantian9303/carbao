package com.yeww.carbao.service.common.impl;

import com.yeww.carbao.dao.common.VerifyCodeMapper;
import com.yeww.carbao.domain.enums.SmsTemplateEnum;
import com.yeww.carbao.domain.request.common.VerifyCodeRequest;
import com.yeww.carbao.model.common.VerifyCodeEntity;
import com.yeww.carbao.service.common.ISmsService;
import com.yeww.carbao.service.common.IVerifyCodeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by yeweiwei1 on 2016/8/9.
 */
@Service
public class VerifyCodeServiceImpl implements IVerifyCodeService {

    private static final Logger Logs = LoggerFactory.getLogger(VerifyCodeServiceImpl.class);

    @Resource
    private VerifyCodeMapper verifyCodeMapper;

    @Resource
    private ISmsService smsService;

    /**
     * 发送验证码
     *
     * @param request
     */
    @Override
    public void sendVerifyCode(VerifyCodeRequest request) {
        VerifyCodeEntity entity = new VerifyCodeEntity();
        entity.setVerifyCode(get6RondomChar());
        entity.setVerifyType(request.getVerifyType());
        entity.setClientType(request.getClientType());
        entity.setClientCode(request.getPhone());
        entity.setCreateTime(new Date());
        verifyCodeMapper.insert(entity);
        if ("phone".equals(request.getClientType())) {
            sendPhoneVerify(entity.getClientCode(), entity.getVerifyCode());
        } else {
            sendEmailVerfiy(entity.getClientCode(), entity.getVerifyCode());
        }
        List verifyList=new ArrayList();
        verifyList.add(entity.getVerifyCode());
        smsService.sendSns(request.getPhone(), SmsTemplateEnum.valueOf(request.getVerifyType()),verifyList);
    }

    /**
     * 验证码是否有效
     *
     * @param verifyCode
     * @param clientType
     * @param clientCode
     * @param verifyType
     * @return
     */
    @Override
    public boolean haveEffective(String verifyCode, String clientType, String clientCode, String verifyType) {

        //以后接redis
        try {
            VerifyCodeEntity paramEntity=new VerifyCodeEntity();
            paramEntity.setClientCode(clientCode);
            paramEntity.setClientType(clientType);
            paramEntity.setVerifyType(verifyType);
            paramEntity.setVerifyCode(verifyCode);
            VerifyCodeEntity entity = verifyCodeMapper.selectOne(paramEntity);
            if(entity==null){
                return false;
            }

            Date now=new Date();
            Date validTime=new Date(now.getTime()-60000);

            if(validTime.after(entity.getCreateTime())){
                entity.setValidSign(-1);
                verifyCodeMapper.update(entity);
                return false;
            }
            entity.setValidSign(-1);
            verifyCodeMapper.update(entity);
            return true;
        } catch (Exception e) {
            Logs.error("haveEffective失败", e);
            return false;
        }
    }

    /**
     * 手机验证码
     */
    private void sendPhoneVerify(String phoneNum, String verifyCode) {

    }

    /**
     * 邮箱验证码
     */
    private void sendEmailVerfiy(String phoneNum, String verifyCode) {

    }


    private String get6RondomChar() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6; i++) {
            sb.append((int) (Math.random() * 10));
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Date now=new Date();
        Date validTime=new Date(now.getTime()-60000);

        System.out.println(validTime.after(now));
    }
}
