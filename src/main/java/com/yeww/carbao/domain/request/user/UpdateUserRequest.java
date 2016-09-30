package com.yeww.carbao.domain.request.user;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/9/6.
 */
public class UpdateUserRequest extends BaseRequest {
    private String name;
    private Integer age;
    private Integer sex;
    private String remark;
    private String headImgUrl;

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

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getHeadImgUrl() {
        return headImgUrl;
    }

    public void setHeadImgUrl(String headImgUrl) {
        this.headImgUrl = headImgUrl;
    }

    @Override
    public String toString() {
        return "UpdateUserRequest{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sex=" + sex +
                ", headImgUrl=" + headImgUrl +
                ", remark='" + remark + '\'' +
                '}';
    }
}
