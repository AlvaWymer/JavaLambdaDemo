package com.amazonaws.lambda.handle;

import java.util.Date;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.lambda.dto.RegisterInfo;
import com.amazonaws.lambda.exception.RegisterException;
import com.amazonaws.lambda.response.RegisterResponse;
import com.amazonaws.lambda.service.impl.IRegisterService;
import com.amazonaws.lambda.service.impl.RegisterServiceImpl;
import com.amazonaws.lambda.util.ValidateUtil;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LambdaFunctionHandler implements RequestHandler<RegisterInfo, RegisterResponse> {

    @Override
    public RegisterResponse handleRequest(RegisterInfo input, Context context) {
    	 LambdaLogger logger = context.getLogger();
         logger.log("[[[[" + new Date() + "]]]]RegisterInfo: " + JSONObject.toJSONString(input));
         if(!ValidateUtil.inputValidate(input)) {
             return new RegisterResponse(RegisterResponse.RESPONSE_CODE_ERROR,"register info error.");
         }
         IRegisterService registerService = new RegisterServiceImpl();
         try {
             registerService.register(input,context);
         } catch (RegisterException e) {
             return new RegisterResponse(RegisterResponse.RESPONSE_CODE_SYS_EXCEPTION, e.getMsg());
         }
         return new RegisterResponse(RegisterResponse.RESPONSE_CODE_SUCCESS,"register success.");
    }

}
