package com.yeww.carbao.model.msg;

import com.yeww.carbao.model.BaseEntity;

/**
 * Created by yeweiwei1 on 2016/9/25.
 */
public class MsgEntity extends BaseEntity {
    private Long userId;
    private String content;
    /**
     * 0:客服
     * 1:用户
     */
    private String from;

    private Integer flag;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }

    @Override
    public String toString() {
        return "MsgEntity{" +
                "userId=" + userId +
                ", content='" + content + '\'' +
                ", from='" + from + '\'' +
                ", flag='" + flag + '\'' +
                '}';
    }
}
