package com.amazonaws.lambda.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class RegisterException extends Exception {
    private static final long serialVersionUID = 8365773790495521094L;

    public static final Integer REGISTER_INFO_ERROR_CODE = 1001;
    public static final Integer REGISTER_SYS_ERROR_CODE = 2001;
    public static final Integer REGISTER_DB_ERROR_CODE = 2002;

	private Integer code;
    private String msg;

    public RegisterException(String message) {
        super(message);
    }
}