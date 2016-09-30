package com.yeww.carbao.domain.response;

import com.yeww.carbao.domain.IConverter;

import java.io.Serializable;

/**
 * Created by yeweiwei1 on 2016/8/8.
 */
public abstract class BaseResponse<T> implements IConverter<T>,Serializable {
    @Override
    public void converter(T t) {

    }
}
