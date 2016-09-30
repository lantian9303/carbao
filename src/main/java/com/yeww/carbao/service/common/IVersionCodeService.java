package com.yeww.carbao.service.common;

import com.yeww.carbao.domain.request.common.VersionCodeQueryRequest;
import com.yeww.carbao.domain.response.common.VersionResponse;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public interface IVersionCodeService {
    VersionResponse checkUpdate(VersionCodeQueryRequest request);
}
