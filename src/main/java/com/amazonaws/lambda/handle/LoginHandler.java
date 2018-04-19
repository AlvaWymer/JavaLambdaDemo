package com.amazonaws.lambda.handle;

import java.util.Date;

import javax.security.auth.login.LoginException;

import com.alibaba.fastjson.JSONObject;
import com.amazonaws.lambda.dto.LoginInfo;
import com.amazonaws.lambda.response.LoginResponse;
import com.amazonaws.lambda.util.ValidateUtil;
import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.LambdaLogger;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class LoginHandler implements RequestHandler<LoginInfo, LoginResponse> {

    @Override
    public LoginResponse handleRequest(LoginInfo input, Context context) {
        LambdaLogger logger = context.getLogger();
        logger.log("---Login----["+new Date()+"]LoginInfo: "+JSONObject.toJSONString(input));
//        if(!ValidateUtil.loginInputValidate(input)) {
//            return new LoginResponse(LoginResponse.RESPONSE_CODE_ERROR,"login info error.");
//        }
//        try {
//            ILoginService loginService = new LoginServiceImpl();
//            return loginService.login(input, context);
//        } catch(LoginException e) {
//            return new LoginResponse(LoginResponse.RESPONSE_CODE_SYS_EXCEPTION,e.getMsg());
//        }
        return null;
    }


}
