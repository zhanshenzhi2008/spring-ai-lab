package com.orjrs.spring.ai.lab.Infrastructure.exception;

import lombok.Setter;

/**
 * 账号封禁异常
 *
 * @author orjrs
 * {@code @date} 2024-10-11 18:32
 */
@Setter
public class AccountDisableException extends RuntimeException {

    /** 错误码 */
    protected Object errorCode;

    /** 错误信息 */
    protected String errorMsg;

    public AccountDisableException(ExceptionInfo exceptionInfo) {
        super(exceptionInfo.getMsg());
        this.errorCode = exceptionInfo.getCode();
        this.errorMsg = exceptionInfo.getMsg();
    }

    public AccountDisableException(String errorMsg) {
        super(errorMsg);
        this.errorCode = 500;
        this.errorMsg = errorMsg;
    }

    public AccountDisableException(Object errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
