package com.yeww.carbao.service.gas;

import com.yeww.carbao.domain.request.gas.FaceValueRequest;
import com.yeww.carbao.domain.response.gas.FaceValueResponse;

import java.util.List;

/**
 * Created by yeweiwei1 on 2016/9/1.
 */
public interface IGasFaceService {
    List<FaceValueResponse> queryFace(FaceValueRequest request);
}
