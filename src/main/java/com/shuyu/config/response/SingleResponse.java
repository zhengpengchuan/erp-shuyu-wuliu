package com.shuyu.config.response;

public class SingleResponse<T> extends Response {
    private T data;

    public SingleResponse() {
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public static SingleResponse buildSuccess() {
        SingleResponse response = new SingleResponse();
        response.setSuccess(true);
        return response;
    }

    public static SingleResponse buildFailure(String errCode, String errMessage) {
        SingleResponse response = new SingleResponse();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static <T> SingleResponse<T> of(T data) {
        SingleResponse<T> response = new SingleResponse();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }

    public static <T> SingleResponse<T> ofError(String errCode, String errMessage, T data) {
        SingleResponse<T> response = new SingleResponse();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        response.setData(data);
        return response;
    }
}