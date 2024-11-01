package com.orjrs.spring.ai.lab.Infrastructure.exception;

import com.orjrs.spring.ai.lab.Infrastructure.enums.HubApiExceptionEnum;
import com.orjrs.spring.ai.lab.Infrastructure.enums.RunExceptionEnum;
import com.orjrs.spring.ai.lab.Infrastructure.vo.ResponseResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 全局异常处理
 *
 * @author orjrs
 * {@code @date} 2024-10-11 18:29
 */
@ControllerAdvice
public class GlobalExceptionHandler<T> {

    /** 日志 */
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    /**
     * 处理自定义的业务异常
     *
     * @param e 异常类
     * @return ResponseResult
     */
    @ExceptionHandler(value = BizException.class)
    @ResponseBody
    public ResponseResult<T> bizExceptionHandler(BizException e) {
        LOG.error("发生业务异常！原因是", e);
        return ResponseResult.error(Integer.parseInt(e.getErrorCode().toString()), e.getErrorMsg());
    }


    /**
     * 处理空指针的异常
     *
     * @param e 异常类
     * @return ResponseResult
     */
    @ExceptionHandler(value = NullPointerException.class)
    @ResponseBody
    public ResponseResult<T> exceptionHandler(NullPointerException e) {
        LOG.error("发生空指针异常！原因是:", e);
        return ResponseResult.error(HubApiExceptionEnum.NULL_POINT);
    }


    /**
     * 处理数据校验异常
     *
     * @param e 异常类
     * @return ResponseResult
     */
    @ExceptionHandler(value = DataIntegrityViolationException.class)
    @ResponseBody
    public ResponseResult<T> exceptionHandler(DataIntegrityViolationException e) {
        LOG.error("数据校验异常！原因是:", e);
        return ResponseResult.error(RunExceptionEnum.DAO_VALIDATE.getCode(),
                String.format(RunExceptionEnum.DAO_VALIDATE.getMsg(), e.getMessage()));
    }

    /**
     * 未登录校验异常
     *
     * @param e 异常类
     * @return ResponseResult
     */
    @ExceptionHandler(NotLoginException.class)
    public ResponseResult<T> handleNotLogin(NotLoginException e) {
        LOG.error("未登录！原因是:", e);
        return ResponseResult.error(RunExceptionEnum.NOT_LOGIN.getCode(),
                String.format(RunExceptionEnum.NOT_LOGIN.getMsg(), e.getMessage()));
    }

    /**
     * 角色校验异常异常
     *
     * @param e 异常类
     * @return ResponseResult
     */
    @ExceptionHandler(NotRoleException.class)
    public ResponseResult<T> handleNotRole(NotRoleException e) {
        LOG.error("角色校验异常！原因是:", e);
        return ResponseResult.error(RunExceptionEnum.ROLE_VALIDATE.getCode(),
                String.format(RunExceptionEnum.ROLE_VALIDATE.getMsg(), e.getMessage()));
    }

    /**
     * 账号封禁校验异常
     *
     * @param e 异常类
     * @return ResponseResult
     */
    @ExceptionHandler(AccountDisableException.class)
    public ResponseResult<T> handleDisabledException(AccountDisableException e) {
        LOG.error("账号封禁！原因是:", e);
        return ResponseResult.error(RunExceptionEnum.ACCOUNT_DISABLE.getCode(),
                String.format(RunExceptionEnum.ACCOUNT_DISABLE.getMsg(), e.getMessage()));
    }


    /**
     * 处理其他异常
     *
     * @param e 异常类
     * @return ResponseResult
     */
    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ResponseResult<T> exceptionHandler(Exception e) {
        LOG.error("未知异常！原因是:", e);
        return ResponseResult.error(RunExceptionEnum.INTERNAL_ERROR.getCode(),
                String.format(RunExceptionEnum.INTERNAL_ERROR.getMsg(), e.getMessage()));
    }
}
