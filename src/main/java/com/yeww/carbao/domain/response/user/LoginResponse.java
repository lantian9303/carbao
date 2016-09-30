package com.yeww.carbao.domain.response.user;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.user.UserEntity;

/**
 * Created by yeweiwei1 on 2016/9/6.
 */
public class LoginResponse extends BaseResponse<UserEntity> {
    private String userId;
    private String carId;
    private String level="1";

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCarId() {
        return carId;
    }

    public void setCarId(String carId) {
        this.carId = carId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    @Override
    public String toString() {
        return "LoginResponse{" +
                "userId='" + userId + '\'' +
                ", carId='" + carId + '\'' +
                ", level='" + level + '\'' +
                '}';
    }
}
