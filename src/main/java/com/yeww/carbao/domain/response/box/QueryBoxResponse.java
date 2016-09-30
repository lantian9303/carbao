package com.yeww.carbao.domain.response.box;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.box.BoxEntity;

/**
 * Created by yeweiwei1 on 2016/9/30.
 */
public class QueryBoxResponse extends BaseResponse<BoxEntity> {
    private Long boxId;
    private String imgUrl;
    private String type;
    private String version;
    private String name;
    private Double price;

    public Long getBoxId() {
        return boxId;
    }

    public void setBoxId(Long boxId) {
        this.boxId = boxId;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void converter(BoxEntity boxEntity) {
        this.boxId=boxEntity.getId();
        this.type=boxEntity.getType();
        this.name=boxEntity.getName();
        this.version=boxEntity.getVersion();
        this.imgUrl=boxEntity.getImgUrl();
        this.price=boxEntity.getPrice();
    }
}
