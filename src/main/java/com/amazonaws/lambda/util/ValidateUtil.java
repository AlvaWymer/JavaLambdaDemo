package com.amazonaws.lambda.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.amazonaws.lambda.dto.RegisterInfo;

public class ValidateUtil {
    /**
     * 校验注册信息
     * 
     * @param info 注册信息
     * @return 是否校验通过
     */
    public static Boolean inputValidate(RegisterInfo info) {
        if (info.getUsername() == null || info.getUsername().trim().equals("")) {
            return false;
        }
        if (info.getEmail()==null || info.getEmail().trim().equals("")) {
            return false;
        }
        //邮箱格式校验
        String regEx = "^[a-zA-Z0-9._-]+@[a-zA-Z0-9_-]+(\\.[a-zA-Z0-9_-]+)+$";
        Pattern pattern = Pattern.compile(regEx);
        Matcher matcher = pattern.matcher(info.getEmail().trim());
        if (!matcher.matches()) {
            return false;
        }
        if (info.getPassword()==null || info.getPassword().trim().equals("")) {
            return false;
        }
        return true;
    }
}