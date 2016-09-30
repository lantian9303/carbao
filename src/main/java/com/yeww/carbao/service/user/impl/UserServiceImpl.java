package com.yeww.carbao.service.user.impl;

import com.yeww.carbao.dao.car.CarMapper;
import com.yeww.carbao.dao.user.UserMapper;
import com.yeww.carbao.domain.request.user.*;
import com.yeww.carbao.domain.response.user.LoginResponse;
import com.yeww.carbao.domain.response.user.QueryUserResponse;
import com.yeww.carbao.model.car.CarEntity;
import com.yeww.carbao.model.user.UserEntity;
import com.yeww.carbao.service.common.IVerifyCodeService;
import com.yeww.carbao.service.user.IUserService;
import com.yeww.carbao.utils.AppException;
import com.yeww.carbao.utils.Md5Util;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by yeweiwei1 on 2016/8/9.
 */
@Service
public class UserServiceImpl implements IUserService {

    @Resource
    private IVerifyCodeService verifyCodeService;

    @Resource
    private UserMapper userMapper;

    @Resource
    private CarMapper carMapper;

    /**
     * 注册
     *
     * @param request
     */
    @Override
    public void register(RegisterRequest request) throws AppException {
        if (!verifyCodeService.haveEffective(request.getCode(), request.getClientType(), request.getPhoneNum(), request.getVerifyType())) {
            throw new AppException("-1", "验证码过期或者错误");
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setCreateTime(new Date());
        userEntity.setUserCode(request.getUsername());
        userEntity.setUserName(request.getUsername());
        userEntity.setPassword(Md5Util.md5Upper32(saltHead, request.getPwd(), salttail));
        userMapper.insert(userEntity);
    }

    /**
     * 修改密码
     *
     * @param request
     */
    @Override
    public void updatePwd(UpdatePwdRequest request) throws AppException {
        String oldPwd = Md5Util.md5Upper32(saltHead, request.getOldPwd(), salttail);
        String newPwd = Md5Util.md5Upper32(saltHead, request.getNewPwd(), salttail);
        Map parmMap = new HashMap();
        parmMap.put("userCode", request.getUserId());
        parmMap.put("password", oldPwd);
        UserEntity entity = null;
        try {
            entity = userMapper.selectOne(parmMap);
            if (entity == null) {
                throw new AppException("-1", "原密码不匹配");
            }
            entity.setPassword(newPwd);
            userMapper.update(entity);
        } catch (AppException e) {
            throw e;
        } catch (Exception e) {
            throw new AppException("-1", "修改密码失败，请联系管理员");
        }
    }

    /**
     * 找回密码
     *
     * @param request
     */
    @Override
    public void recoverPassword(RecoverPwdRequest request) throws AppException {
        if (!verifyCodeService.haveEffective(request.getCode(), request.getClientType(), request.getPhoneNum(), request.getVerifyType())) {
            throw new AppException("-1", "验证码过期或者错误");
        }
        UserEntity entity = null;
        try {
            Map paramMap = new HashMap();
            paramMap.put("userCode", request.getUserName());
            entity = userMapper.selectOne(paramMap);
            if (entity == null) {
                throw new AppException("-1", "用户不存在");
            }
            entity.setPassword(request.getPwd());
            userMapper.update(entity);
        } catch (Exception e) {
            throw new AppException("-1", "找回密码失败，请联系管理员");
        }
    }

    /**
     * 登录
     *
     * @param request
     * @return
     */
    @Override
    public LoginResponse login(LoginRequest request) throws AppException {
        UserEntity entity = null;
        LoginResponse loginResponse = null;
        try {
            Map paramMap = new HashMap();
            paramMap.put("userCode", request.getUsername());
            paramMap.put("password", Md5Util.md5Upper32(saltHead, request.getPwd(), salttail));
            entity = userMapper.selectOne(paramMap);
            if (entity == null) {
                throw new AppException("-1", "用户不存在");
            }
            loginResponse = new LoginResponse();
            //
            loginResponse.setUserId(entity.getId().toString());
            Map carMap = new HashMap();
            carMap.put("userId", entity.getId());
            CarEntity carEntity = carMapper.selectOne(carMap);
            if (carEntity != null) {
                loginResponse.setCarId(carEntity.getId().toString());
            }
            return loginResponse;
        } catch (Exception e) {
            throw new AppException("-1", "找回密码失败，请联系管理员");
        }
    }

    /**
     * 修改个人信息
     *
     * @param request
     */
    @Override
    public void update(UpdateUserRequest request) throws AppException {
        UserEntity entity = userMapper.selectById(Long.parseLong(request.getUserId()));
        if (entity == null) {
            throw new AppException("-1", "用户不存在");
        }
        entity.setUserName(request.getName());
        entity.setRemark(request.getRemark());
        entity.setAge(request.getAge());
        entity.setSex(request.getSex());
        userMapper.update(entity);
    }

    /**
     * 取得用户信息
     *
     * @param request
     * @return
     */
    @Override
    public QueryUserResponse getInfo(QueryUserRequest request) throws AppException {
        UserEntity entity = userMapper.selectById(Long.parseLong(request.getUserId()));
        if (entity == null) {
            throw new AppException("-1", "用户不存在");
        }
        QueryUserResponse response = new QueryUserResponse();
        response.converter(entity);
        Map carMap = new HashMap();
        carMap.put("userId", entity.getId());
        CarEntity carEntity = carMapper.selectOne(carMap);
        if (carEntity != null) {
            response.setCarId(carEntity.getId());
        }
        return response;
    }
}
