package com.shuyu.config.response;

import java.util.Collections;
import java.util.List;

public class PageResponse<T> extends Response {
    private static final long serialVersionUID = 1L;
    private long totalCount = 0;
    private int pageSize = 1;
    private int pageIndex = 1;
    private List<T> data;

    public PageResponse() {
    }

    public long getTotalCount() {
        return this.totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return this.pageSize < 1 ? 1 : this.pageSize;
    }

    public void setPageSize(int pageSize) {
        if (pageSize < 1) {
            this.pageSize = 1;
        } else {
            this.pageSize = pageSize;
        }

    }

    public int getPageIndex() {
        return this.pageIndex < 1 ? 1 : this.pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        if (pageIndex < 1) {
            this.pageIndex = 1;
        } else {
            this.pageIndex = pageIndex;
        }

    }

    public List<T> getData() {
        return null == this.data ? Collections.emptyList() : this.data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public long getTotalPages() {
        return this.totalCount % this.pageSize == 0 ? this.totalCount / this.pageSize : this.totalCount / this.pageSize + 1;
    }

    public boolean isEmpty() {
        return this.data == null || this.data.size() == 0;
    }

    public boolean isNotEmpty() {
        return !this.isEmpty();
    }

    public static PageResponse buildSuccess() {
        PageResponse response = new PageResponse();
        response.setSuccess(true);
        return response;
    }

    public static PageResponse buildFailure(String errCode, String errMessage) {
        PageResponse response = new PageResponse();
        response.setSuccess(false);
        response.setErrCode(errCode);
        response.setErrMessage(errMessage);
        return response;
    }

    public static <T> PageResponse<T> of(int pageSize, int pageIndex) {
        PageResponse<T> response = new PageResponse();
        response.setSuccess(true);
        response.setData(Collections.emptyList());
        response.setTotalCount(0);
        response.setPageSize(pageSize);
        response.setPageIndex(pageIndex);
        return response;
    }

    public static <T> PageResponse<T> of(List<T> data, long totalCount, int pageSize, int pageIndex) {
        PageResponse<T> response = new PageResponse();
        response.setSuccess(true);
        response.setData(data);
        response.setTotalCount(totalCount);
        response.setPageSize(pageSize);
        response.setPageIndex(pageIndex);
        return response;
    }
}