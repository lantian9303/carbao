package com.yeww.carbao.domain.response.msg;

import com.yeww.carbao.domain.response.BaseResponse;
import com.yeww.carbao.model.msg.MsgEntity;
import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.commons.lang.time.DateUtils;

import java.text.DateFormat;
import java.util.Date;

/**
 * Created by yeweiwei1 on 2016/9/25.
 */
public class MsgQueryResponse extends BaseResponse<MsgEntity> {
    private Long msgId;
    private String content;
    private String time;
    private String from;
    private String imgUrl;

    public Long getMsgId() {
        return msgId;
    }

    public void setMsgId(Long msgId) {
        this.msgId = msgId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    @Override
    public void converter(MsgEntity msgEntity) {
        this.msgId=msgEntity.getId();
        this.content=msgEntity.getContent();
        this.time= DateFormatUtils.format(msgEntity.getCreateTime(),"yyyyMMddhhmmss");
        this.from=msgEntity.getFrom();
    }

    public static void main(String[] args) {
        System.out.println(DateFormatUtils.format(new Date(),"yyyyMMddhhmmss"));
    }
}
