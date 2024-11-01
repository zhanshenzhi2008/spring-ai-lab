package com.orjrs.spring.ai.lab.Infrastructure.enums;


import com.orjrs.spring.ai.lab.Infrastructure.exception.ExceptionInfo;

/**
 * 运行异常枚举类
 *
 * @author orjrs
 * @date 2024-10-11 18:37
 */
public enum RunExceptionEnum implements ExceptionInfo {
    /** 500-数据校验异常 */
    DAO_VALIDATE(500, "数据校验异常:【%s】!"),

    /** 5000-服务器内部异常 */
    INTERNAL_ERROR(5000, "服务器内部异常:【%s】!"),

    /** 5001-未登录 */
    NOT_LOGIN(5004, "未登录:【%s】!"),

    /** 5002-角色校验 */
    ROLE_VALIDATE(5004, "角色校验:【%s】!"),

    /** 5003-账号封禁 */
    ACCOUNT_DISABLE(5004, "账号封禁:【%s】!"),

    ;

    /** 错误码 */
    private Integer code;

    /** 错误描述 */
    private String msg;

    RunExceptionEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    @Override
    public Integer getCode() {
        return this.code;
    }


    @Override
    public String getMsg() {
        return this.msg;
    }
}
