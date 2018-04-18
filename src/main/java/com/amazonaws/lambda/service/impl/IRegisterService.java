package com.amazonaws.lambda.service.impl;

import com.amazonaws.lambda.dto.RegisterInfo;
import com.amazonaws.lambda.exception.RegisterException;
import com.amazonaws.services.lambda.runtime.Context;

public interface IRegisterService {
    /**
     * 注册
     * @param info 注册信息
     * @throws RegisterException
     */
    public void register(RegisterInfo info, Context context) throws RegisterException;
}