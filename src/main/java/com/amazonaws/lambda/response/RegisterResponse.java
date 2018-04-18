package com.amazonaws.lambda.response;

import java.util.List;
import java.util.Map;

import com.amazonaws.lambda.dto.RegisterInfo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterResponse {
    public static final Integer RESPONSE_CODE_SUCCESS = 1000;
    public static final Integer RESPONSE_CODE_ERROR = 1001;
    public static final Integer RESPONSE_CODE_SYS_EXCEPTION = 1002;

    private Integer code;
	private String message;
    private List<Object> rows;
    private Map<Object, Object> map;

    public RegisterResponse(Integer code,String message) {
        this.code = code;
        this.message = message;
    }

   
}