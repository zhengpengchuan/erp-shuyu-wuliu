package com.shuyu.config.response;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MultiResponse<T> extends Response {
    private static final long serialVersionUID = 1L;
    private List<T> data;

    public MultiResponse() {
    }

    public List<T> getData() {
        return (List)(null == this.data ? Collections.emptyList() : new ArrayList(this.data));
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public boolean isEmpty() {
        return this.data == null || this.data.size() == 0;
    }

    public boolean isNotEmpty() {
        return !this.isEmpty();
    }

    public static MultiResponse buildSuccess() {
        MultiResponse response = new MultiResponse();
        response.setSuccess(true);
        return response;
    }

    public static MultiResponse buildFailure(String errCode, String errMessage) {
        MultiResponse response = new MultiResponse();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static <T> MultiResponse<T> of(List<T> data) {
        MultiResponse<T> response = new MultiResponse();
        response.setSuccess(true);
        response.setData(data);
        return response;
    }
}