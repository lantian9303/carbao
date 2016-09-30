package com.yeww.carbao.service.box.impl;

import com.yeww.carbao.dao.box.BoxMapper;
import com.yeww.carbao.dao.box.BoxOrderMapper;
import com.yeww.carbao.domain.request.box.CreateBoxOrderRequest;
import com.yeww.carbao.domain.request.box.QueryBoxOrderRequest;
import com.yeww.carbao.domain.response.box.CreateBoxOrderResponse;
import com.yeww.carbao.domain.response.box.QueryBoxOrderResponse;
import com.yeww.carbao.domain.response.box.QueryBoxResponse;
import com.yeww.carbao.model.box.BoxEntity;
import com.yeww.carbao.model.box.BoxOrderEntity;
import com.yeww.carbao.service.box.IBoxService;
import org.apache.commons.lang.time.DateFormatUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by yeweiwei1 on 2016/9/30.
 */
@Service
public class BoxServiceImpl implements IBoxService {

    @Resource
    private BoxMapper boxMapper;

    @Resource
    private BoxOrderMapper boxOrderMapper;

    /**
     * 盒子信息查询
     *
     * @return
     */
    @Override
    public QueryBoxResponse boxQuery() {
        BoxEntity boxEntity = boxMapper.selectById(1l);
        QueryBoxResponse response = new QueryBoxResponse();
        response.converter(boxEntity);
        return response;
    }

    /**
     * 创建盒子订单
     *
     * @param request
     * @return
     */
    @Override
    public CreateBoxOrderResponse createBoxOrder(CreateBoxOrderRequest request) {
        BoxEntity boxEntity = boxMapper.selectById(request.getBoxId());
        if (boxEntity == null) {
            return null;
        }
        String orderNum = getOrderNum();
        BoxOrderEntity entity = new BoxOrderEntity();
        entity.setUserId(Long.parseLong(request.getUserId()));
        entity.setBoxId(request.getBoxId());
        entity.setOrderNum(orderNum);
        entity.setPrice(boxEntity.getPrice());
        entity.setStatus(0);
        entity.setContent("购买盒子");
        entity.setCreateTime(new Date());
        boxOrderMapper.insert(entity);
        CreateBoxOrderResponse response = new CreateBoxOrderResponse();
        response.converter(entity);
        return response;
    }

    /**
     * 查询订单列表
     *
     * @param request
     * @return
     */
    @Override
    public List<QueryBoxOrderResponse> queryBoxOrderList(QueryBoxOrderRequest request) {
        Map paramMap = new HashMap();
        List<BoxOrderEntity> boxOrderEntityList = boxOrderMapper.queryBoxOrderList(paramMap);
        if (CollectionUtils.isEmpty(boxOrderEntityList)) {
            return null;
        }
        List<QueryBoxOrderResponse> responseList = new ArrayList<QueryBoxOrderResponse>();
        for (BoxOrderEntity entity : boxOrderEntityList) {
            QueryBoxOrderResponse response = new QueryBoxOrderResponse();
            response.converter(entity);
            responseList.add(response);
        }
        return responseList;
    }

    private String getOrderNum() {
        return "BOX" + DateFormatUtils.format(new Date(), "yyyyMMddHHmmssSSS");
    }

    public static void main(String[] args) {
        System.out.println(new BoxServiceImpl().getOrderNum());
    }
}
