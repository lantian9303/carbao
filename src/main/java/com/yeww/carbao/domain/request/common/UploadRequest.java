package com.yeww.carbao.domain.request.common;

import com.yeww.carbao.domain.request.BaseRequest;
import org.springframework.web.multipart.MultipartFile;

/**
 * Created by yeweiwei1 on 2016/9/12.
 */
public class UploadRequest extends BaseRequest {
    private MultipartFile file;

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
