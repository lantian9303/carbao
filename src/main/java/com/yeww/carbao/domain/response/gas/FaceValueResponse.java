package com.yeww.carbao.domain.response.gas;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.gas.GasFaceEntity;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public class FaceValueResponse extends BaseResponse<GasFaceEntity> {
    private Integer ticketId;
    private Double total;
    private Double discount;

    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }

    @Override
    public void converter(GasFaceEntity gasFaceEntity) {
        this.ticketId=gasFaceEntity.getId().intValue();
        this.total=gasFaceEntity.getFaceValue();
        this.discount=gasFaceEntity.getDiscount();
    }
}
