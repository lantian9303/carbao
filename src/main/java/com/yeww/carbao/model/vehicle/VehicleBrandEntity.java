package com.yeww.carbao.model.vehicle;

import com.yeww.carbao.model.BaseEntity;

/**
 * Created by yeweiwei1 on 2016/8/17.
 */
public class VehicleBrandEntity extends BaseEntity {
    private Integer pid;
    private String name;
    private String urlSpell;
    private String tSpell;

    private Integer temId;

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrlSpell() {
        return urlSpell;
    }

    public void setUrlSpell(String urlSpell) {
        this.urlSpell = urlSpell;
    }

    public String gettSpell() {
        return tSpell;
    }

    public void settSpell(String tSpell) {
        this.tSpell = tSpell;
    }

    public Integer getTemId() {
        return temId;
    }

    public void setTemId(Integer temId) {
        this.temId = temId;
    }
}
