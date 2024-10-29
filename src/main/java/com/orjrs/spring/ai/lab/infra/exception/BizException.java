package com.orjrs.spring.ai.lab.infra.exception;

import lombok.Getter;

/**
 * 业务异常
 *
 * @author orjrs
 * {@code @date} 2024-10-11 18:32
 */
@Getter
public class BizException extends RuntimeException {

    /** 错误码 */
    protected Object errorCode;

    /** 错误信息 */
    protected String errorMsg;

    public void setErrorCode(Object errorCode) {
        this.errorCode = errorCode;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

    public BizException(ExceptionInfo exceptionInfo) {
        super(exceptionInfo.getMsg());
        this.errorCode = exceptionInfo.getCode();
        this.errorMsg = exceptionInfo.getMsg();
    }

    public BizException(String errorMsg) {
        super(errorMsg);
        this.errorCode = 500;
        this.errorMsg = errorMsg;
    }

    public BizException(Object errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
