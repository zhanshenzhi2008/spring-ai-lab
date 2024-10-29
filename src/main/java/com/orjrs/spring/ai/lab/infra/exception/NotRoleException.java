package com.orjrs.spring.ai.lab.infra.exception;

import lombok.Setter;

/**
 * 角色校验 异常
 *
 * @author orjrs
 * {@code @date} 2024-10-11 18:32
 */
@Setter
public class NotRoleException extends RuntimeException {

    /** 错误码 */
    protected Object errorCode;

    /** 错误信息 */
    protected String errorMsg;

    public NotRoleException(ExceptionInfo exceptionInfo) {
        super(exceptionInfo.getMsg());
        this.errorCode = exceptionInfo.getCode();
        this.errorMsg = exceptionInfo.getMsg();
    }

    public NotRoleException(String errorMsg) {
        super(errorMsg);
        this.errorCode = 500;
        this.errorMsg = errorMsg;
    }

    public NotRoleException(Object errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
