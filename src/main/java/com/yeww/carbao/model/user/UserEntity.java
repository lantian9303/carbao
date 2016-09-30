package com.yeww.carbao.model.user;

import com.yeww.carbao.model.BaseEntity;

/**
 * Created by yeweiwei1 on 2016/8/8.
 */
public class UserEntity extends BaseEntity {
    private String userCode;
    private String userName;
    private String password;
    private Integer age;
    private Integer sex;
    private String headImg;
    private String remark;

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
    public String toString() {
        return "UserEntity{" +
                "userCode='" + userCode + '\'' +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", age='" + age + '\'' +
                ", sex='" + sex + '\'' +
                ", headImg='" + headImg + '\'' +
                ", remark='" + remark + '\'' +
                '}';
    }
}
