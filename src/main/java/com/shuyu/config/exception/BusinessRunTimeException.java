package com.zc.common.core.exception;


public class BusinessRunTimeException extends RuntimeException{

    private String errCode;
    private String errMessage;

    public BusinessRunTimeException(String errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public BusinessRunTimeException(String errCode, String errMessage, String message, Throwable cause) {
        super(message, cause);
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public String getErrCode() {
        return errCode;
    }

    public String getErrMessage() {
        return errMessage;
    }
}
