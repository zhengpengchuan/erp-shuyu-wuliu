package com.zc.common.core.enums;

public enum ErrorCodeEnum {
    //公共错误
    INTERNAL_SERVER_ERROR("15001", "系统内部错误！", "系统内部错误！"),
    DICT_ITEM_ERROR("15604", "字典数据不存在", "字典数据不存在"),
    ;
    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String message;

    /**
     * 具体错误描述
     */
    private String error;

    ErrorCodeEnum(String code, String message, String error) {
        this.code = code;
        this.message = message;
        this.error = error;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
