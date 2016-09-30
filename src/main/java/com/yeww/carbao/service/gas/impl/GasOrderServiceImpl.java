package com.yeww.carbao.service.gas.impl;

import com.yeww.carbao.dao.gas.GasFaceMapper;
import com.yeww.carbao.dao.gas.GasOrderMapper;
import com.yeww.carbao.domain.request.gas.CreateOrderRequest;
import com.yeww.carbao.domain.response.gas.CreateOrderResponse;
import com.yeww.carbao.model.gas.GasFaceEntity;
import com.yeww.carbao.model.gas.GasOrderEntity;
import com.yeww.carbao.service.gas.IGasOrderService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by yeweiwei1 on 2016/9/30.
 */
@Service
public class GasOrderServiceImpl implements IGasOrderService {

    @Resource
    private GasFaceMapper gasFaceMapper;

    @Resource
    private GasOrderMapper gasOrderMapper;

    /**
     * 创建订单
     *
     * @param request
     * @return
     */
    @Override
    public CreateOrderResponse createGasOrder(CreateOrderRequest request) {
        GasFaceEntity gasFaceEntity = gasFaceMapper.selectById(request.getTicketId());
        if (gasFaceEntity == null) {
            return null;
        }
        String orderNum = getOrderNum();
        GasOrderEntity entity = new GasOrderEntity();
        entity.setUserId(Long.parseLong(request.getUserId()));
        entity.setFaceId(request.getTicketId());
        entity.setOrderNum(orderNum);
        entity.setPrice(new BigDecimal(gasFaceEntity.getFaceValue().toString()).multiply(new BigDecimal(gasFaceEntity.getDiscount().toString())).doubleValue());
        entity.setStatus(0);
        entity.setContent("加油订单");
        entity.setCreateTime(new Date());
        gasOrderMapper.insert(entity);
        CreateOrderResponse response = new CreateOrderResponse();
        response.converter(entity);
        return response;
    }

    private String getOrderNum() {
        return "GAS" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS");
    }
}
