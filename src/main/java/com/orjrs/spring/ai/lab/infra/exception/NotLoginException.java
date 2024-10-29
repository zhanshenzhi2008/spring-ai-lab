package com.orjrs.spring.ai.lab.infra.exception;

import lombok.Setter;

/**
 * 登录异常
 *
 * @author orjrs
 * {@code @date} 2024-10-11 18:32
 */
@Setter
public class NotLoginException extends RuntimeException {

    /** 错误码 */
    protected Object errorCode;

    /** 错误信息 */
    protected String errorMsg;

    public NotLoginException(ExceptionInfo exceptionInfo) {
        super(exceptionInfo.getMsg());
        this.errorCode = exceptionInfo.getCode();
        this.errorMsg = exceptionInfo.getMsg();
    }

    public NotLoginException(String errorMsg) {
        super(errorMsg);
        this.errorCode = 500;
        this.errorMsg = errorMsg;
    }

    public NotLoginException(Object errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
