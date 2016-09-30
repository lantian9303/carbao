package com.yeww.carbao.service.user;

import com.yeww.carbao.domain.request.user.*;
import com.yeww.carbao.domain.response.user.LoginResponse;
import com.yeww.carbao.domain.response.user.QueryUserResponse;
import com.yeww.carbao.utils.AppException;

/**
 * Created by yeweiwei1 on 2016/8/9.
 */
public interface IUserService {

    String saltHead = "test";

    String salttail = "test";

    /**
     * 注册
     *
     * @param request
     */
    void register(RegisterRequest request) throws AppException;

    /**
     * 修改密码
     *
     * @param request
     */
    void updatePwd(UpdatePwdRequest request) throws AppException;

    /**
     * 找回密码
     *
     * @param request
     */
    void recoverPassword(RecoverPwdRequest request) throws AppException;

    /**
     * 登录
     *
     * @param request
     * @return
     */
    LoginResponse login(LoginRequest request) throws AppException;

    /**
     * 修改个人信息
     *
     * @param request
     */
    void update(UpdateUserRequest request) throws AppException;

    /**
     * 取得用户信息
     *
     * @param request
     * @return
     */
    QueryUserResponse getInfo(QueryUserRequest request) throws AppException;
}
