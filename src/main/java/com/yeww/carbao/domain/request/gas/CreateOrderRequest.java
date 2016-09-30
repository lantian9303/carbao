package com.yeww.carbao.domain.request.gas;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/9/30.
 */
public class CreateOrderRequest extends BaseRequest {
    private Long ticketId;

    public Long getTicketId() {
        return ticketId;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    @Override
    public String toString() {
        return "CreateOrderRequest{" +
                "ticketId=" + ticketId +
                '}';
    }
}
