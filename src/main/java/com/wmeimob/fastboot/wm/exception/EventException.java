package com.wmeimob.fastboot.wm.exception;

/**
 * 微盟事件异常，接收微盟消息时有可能抛出
 * Author: LYQ
 */
public class EventException extends RuntimeException {

    public EventException() {
        super();
    }

    public EventException(String message) {
        super(message);
    }

    public EventException(String message, Throwable cause) {
        super(message, cause);
    }

    public EventException(Throwable cause) {
        super(cause);
    }

    protected EventException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
