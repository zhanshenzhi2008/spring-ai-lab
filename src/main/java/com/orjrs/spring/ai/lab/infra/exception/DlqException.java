package com.orjrs.spring.ai.lab.infra.exception;

import lombok.Setter;

/**
 * 死信队列异常--该异常目的是将业务异常进入死信队列进行重新处理
 *
 * @author orjrs
 * {@code @date} 2024-10-11 18:32
 */
@Setter
public class DlqException extends RuntimeException {

    /** 错误码 */
    protected Object errorCode;

    /** 错误信息 */
    protected String errorMsg;

    public DlqException(ExceptionInfo exceptionInfo) {
        super(exceptionInfo.getMsg());
        this.errorCode = exceptionInfo.getCode();
        this.errorMsg = exceptionInfo.getMsg();
    }

    public DlqException(String errorMsg) {
        super(errorMsg);
        this.errorCode = 500;
        this.errorMsg = errorMsg;
    }

    public DlqException(Object errorCode, String errorMsg) {
        super(errorMsg);
        this.errorCode = errorCode;
        this.errorMsg = errorMsg;
    }

}
