package com.nane.exception;

import com.nane.response.ErrorCode;
import com.nane.response.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
@Slf4j
@ResponseBody
public class GlobalException {

    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e) {
        log.error("system server error", e);
        return new Result(ErrorCode.SYSTEM_ERROR);
    }

    @ExceptionHandler(BizException.class)
    public Result handleBizException(BizException e) {
        log.error("biz exception occur", e);
        return new Result(e.getCode(), e.getMessage());
    }
}
