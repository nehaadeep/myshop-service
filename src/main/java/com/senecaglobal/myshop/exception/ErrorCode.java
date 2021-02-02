package com.senecaglobal.myshop.exception;

/**
 * @description: List the error  codes here
 * @author: Suresh_Vannale
 */
public enum ErrorCode {
    INTERNAL_SERVER_ERROR("INTERNAL_SERVER_ERROR"),

    BAD_REQUEST("BAD_REQUEST");

    private final String code;

    ErrorCode(String code) {
        this.code = code;
    }

    public String getErrorCode() {
        return code;
    }
}
