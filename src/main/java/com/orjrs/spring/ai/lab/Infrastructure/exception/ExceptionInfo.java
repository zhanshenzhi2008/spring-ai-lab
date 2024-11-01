package com.orjrs.spring.ai.lab.Infrastructure.exception;


/**
 * 通用异常接口
 *
 * @author orjrs
 * {@code @date} 2024-10-11 18:34
 */
public interface ExceptionInfo {

    /**
     * 错误码 支持返回String、 Integer类型，不要用POJO
     *
     * @return Object
     */
    Object getCode();

    /**
     * 错误描述
     *
     * @return Object
     */
    String getMsg();
}
