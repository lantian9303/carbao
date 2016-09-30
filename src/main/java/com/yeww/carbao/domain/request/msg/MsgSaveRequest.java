package com.yeww.carbao.domain.request.msg;

import com.yeww.carbao.domain.request.BaseRequest;

/**
 * Created by yeweiwei1 on 2016/9/25.
 */
public class MsgSaveRequest extends BaseRequest {
    /**
     * 0:客服
     * 1:用户
     */
    private String from="1";

    private String content;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String toString() {
        return "MsgSaveRequest{" +
                "from='" + from + '\'' +
                "content='" + content + '\'' +
                '}';
    }
}
