package com.yeww.carbao.service.msg.impl;

import com.yeww.carbao.dao.msg.MsgMapper;
import com.yeww.carbao.dao.user.UserMapper;
import com.yeww.carbao.domain.request.msg.MsgQueryRequest;
import com.yeww.carbao.domain.request.msg.MsgSaveRequest;
import com.yeww.carbao.domain.request.msg.MsgWarnRequest;
import com.yeww.carbao.domain.response.msg.MsgQueryResponse;
import com.yeww.carbao.domain.response.msg.MsgWarnResponse;
import com.yeww.carbao.model.msg.MsgEntity;
import com.yeww.carbao.model.user.UserEntity;
import com.yeww.carbao.service.msg.IMsgService;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import javax.annotation.Resource;
import java.util.*;

/**
 * Created by yeweiwei1 on 2016/9/25.
 */
@Service
public class MsgServiceImpl implements IMsgService {

    @Resource
    private UserMapper userMapper;

    @Resource
    private MsgMapper msgMapper;

    /**
     * 消息保存
     *
     * @param request
     */
    @Override
    public void save(MsgSaveRequest request) {
        MsgEntity entity = new MsgEntity();
        entity.setCreateTime(new Date());
        entity.setModifyTime(entity.getCreateTime());
        entity.setContent(request.getContent());
        entity.setFrom(request.getFrom());
        entity.setFlag(0);
        entity.setUserId(Long.parseLong(request.getUserId()));
        msgMapper.insert(entity);
    }

    /**
     * 消息提醒
     *
     * @param request
     */
    @Override
    public MsgWarnResponse warn(MsgWarnRequest request) {
        Map paramMap = new HashMap();
        paramMap.put("flag", "0");
        paramMap.put("from", "0");
        paramMap.put("userId", request.getUserId());
        List<MsgEntity> msgEntityList = msgMapper.selectList(paramMap);
        MsgWarnResponse response = new MsgWarnResponse();
        if (CollectionUtils.isEmpty(msgEntityList)) {
            response.setFlag(0);
        } else {
            response.setFlag(1);
        }
        return response;
    }

    /**
     * 消息查询
     *
     * @param request
     * @return
     */
    @Override
    public List<MsgQueryResponse> query(MsgQueryRequest request) {
        UserEntity userEntity=userMapper.selectById(Long.parseLong(request.getUserId()));
        if(userEntity==null){
            return null;
        }
        Map paramMap = new HashMap();
        paramMap.put("userId", request.getUserId());
        List<MsgEntity> msgEntityList = msgMapper.selectList(paramMap);
        if(CollectionUtils.isEmpty(msgEntityList)){
            return null;
        }
        List<MsgQueryResponse> responseList=new ArrayList<MsgQueryResponse>(msgEntityList.size());
        for(MsgEntity msgEntity:msgEntityList){
            MsgQueryResponse response=new MsgQueryResponse();
            response.converter(msgEntity);
            response.setImgUrl(userEntity.getHeadImg());
            responseList.add(response);
        }
        return responseList;
    }
}
