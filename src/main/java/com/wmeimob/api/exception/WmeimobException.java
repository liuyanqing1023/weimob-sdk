package com.wmeimob.api.exception;

import java.util.Map;

/**
 * @author LYQ
 * @Classname MessageHandler
 * @Description  微盟异常，微盟服务器返回错误时抛出的异常
 * @Date 2020-09-22 14:45
 * @Version V1.0
 */
public class WmeimobException extends RuntimeException {

    /**
     * 微盟返回的errcode
     */
    private Integer code;

    public WmeimobException(Map<String, ?> errMap) {
        super("[" + errMap.get("errcode") + "]" + errMap.get("errmsg"));
        code = (Integer)errMap.get("errcode");
    }

    public WmeimobException() {
        super();
    }

    public WmeimobException(String message) {
        super(message);
    }

    public WmeimobException(String message, Throwable cause) {
        super(message, cause);
    }

    public WmeimobException(Throwable cause) {
        super(cause);
    }

    protected WmeimobException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public Integer getCode() {
        return code;
    }
}
