package com.shuyu.config.enums;

/**
 * @author 郑鹏川
 */
public enum ErrorCodeEnum {
    //公共错误
    INTERNAL_SERVER_ERROR("10000", "系统内部错误！"),
    DICT_ITEM_ERROR("10001", "字典数据不存在"),
    PARAM_ERROR("10002", "参数错误"),
    PARAM_NULL_ERROR("10003", "参数不能为空"),
    ;
    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String message;

    ErrorCodeEnum(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
