package com.yeww.carbao.domain.response.box;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.box.BoxOrderEntity;
import org.apache.commons.lang.time.DateFormatUtils;

/**
 * Created by yeweiwei1 on 2016/9/30.
 */
public class QueryBoxOrderResponse extends BaseResponse<BoxOrderEntity> {
    private Long orderId;
    private String orderNo;
    private Integer status;
    private String content;
    private Double price;
    private String time;


    @Override
    public void converter(BoxOrderEntity boxOrderEntity) {
        this.orderId = boxOrderEntity.getId();
        this.orderNo = boxOrderEntity.getOrderNum();
        this.status = boxOrderEntity.getStatus();
        this.content = boxOrderEntity.getContent();
        this.price = boxOrderEntity.getPrice();
        this.time = DateFormatUtils.format(boxOrderEntity.getCreateTime(), "yyyyMMddHHmmss");
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
