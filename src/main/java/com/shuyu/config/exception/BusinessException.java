package com.zc.common.core.exception;

/**
 * @program: zc-erp
 * @description: 业务错误
 * @author: ransen
 * @create: 2021-03-30 09:33
 **/
public class BusinessException extends Exception{

    private String errCode;
    private String errMessage;

    public BusinessException(String errCode, String errMessage) {
        this.errCode = errCode;
        this.errMessage = errMessage;
    }

    public BusinessException(String errCode, String errMessage,String message, Throwable cause) {
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
