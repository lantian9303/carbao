package com.yeww.carbao.controller.user;

import com.yeww.carbao.domain.request.user.*;
import com.yeww.carbao.domain.response.AppResponse;
import com.yeww.carbao.domain.response.user.LoginResponse;
import com.yeww.carbao.domain.response.user.QueryUserResponse;
import com.yeww.carbao.service.user.IUserService;
import com.yeww.carbao.utils.AppException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * Created by yeweiwei1 on 2016/8/9.
 */
@Controller
@RequestMapping(value = "/user/")
public class UserController {

    private static final Logger Logs = LoggerFactory.getLogger(UserController.class);

    @Resource
    private IUserService userService;

    /**
     * 登录
     *
     * @return
     */
    @RequestMapping(value = "login")
    @ResponseBody
    public AppResponse login(@RequestBody LoginRequest request) {
        Logs.info("login参数信息：", request);
        AppResponse response = new AppResponse();
        try {
            LoginResponse loginResponse = userService.login(request);
            response.setData(loginResponse);
            Logs.info("login返回信息：", response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping(value = "logout")
    @ResponseBody
    public AppResponse logout() {
        return null;
    }

    /**
     * 退出登录
     *
     * @return
     */
    @RequestMapping(value = "getInfo")
    @ResponseBody
    public AppResponse getInfo(QueryUserRequest request) {
        Logs.info("getInfo参数信息：", request);
        AppResponse response = new AppResponse();
        try {
            QueryUserResponse userResponse = userService.getInfo(request);
            response.setData(userResponse);
            Logs.info("getInfo返回信息：", response);
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }


    /**
     * 注册
     *
     * @return
     */
    @RequestMapping(value = "register")
    @ResponseBody
    public AppResponse register(@RequestBody RegisterRequest request) {
        AppResponse response = new AppResponse();
        try {
            userService.register(request);
            Logs.info("register返回信息：", response);
        } catch (AppException e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
            response.setRetinfo(e.getErrorDesc());
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }

    /**
     * 信息修改
     *
     * @return
     */
    @RequestMapping(value = "update")
    @ResponseBody
    public AppResponse update(@RequestBody UpdateUserRequest request) {
        AppResponse response = new AppResponse();
        try {
            userService.update(request);
            Logs.info("register返回信息：", response);
        } catch (AppException e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
            response.setRetinfo(e.getErrorDesc());
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }

    /**
     * 修改密码
     *
     * @return
     */
    @RequestMapping(value = "update-pwd")
    @ResponseBody
    public AppResponse updatePassword(@RequestBody UpdatePwdRequest request) {
        AppResponse response = new AppResponse();
        try {
            userService.updatePwd(request);
            Logs.info("updatePassword返回信息：", response);
        } catch (AppException e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
            response.setRetinfo(e.getErrorDesc());
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }

    /**
     * 找回密码
     *
     * @return
     */
    @RequestMapping(value = "recover-pwd")
    @ResponseBody
    public AppResponse recoverPassword(@RequestBody RecoverPwdRequest request) {
        AppResponse response = new AppResponse();
        try {
            userService.recoverPassword(request);
            Logs.info("recoverPassword返回信息：", response);
        } catch (AppException e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
            response.setRetinfo(e.getErrorDesc());
        } catch (Exception e) {
            Logs.error("操作失败：", e);
            response.setCodeError(AppResponse.CodeEnum.ERROR);
        }
        return response;
    }
}
