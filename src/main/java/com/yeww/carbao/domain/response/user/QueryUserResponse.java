package com.yeww.carbao.domain.response.user;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.user.UserEntity;

/**
 * Created by yeweiwei1 on 2016/9/6.
 */
public class QueryUserResponse extends BaseResponse<UserEntity> {
    private String username;
    private String name;
    private Integer age;
    private Integer sex;
    private String level="1";
    private Long carId;
    private String headImg;
    private String remark;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getHeadImg() {
        return headImg;
    }

    public void setHeadImg(String headImg) {
        this.headImg = headImg;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Override
    public void converter(UserEntity userEntity) {
        this.username=userEntity.getUserCode();
        this.age=userEntity.getAge();
        this.sex=userEntity.getSex();
        this.name=userEntity.getUserName();
        this.remark=userEntity.getRemark();
        this.headImg=userEntity.getHeadImg();
    }
}
