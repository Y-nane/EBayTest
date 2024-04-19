package com.nane.exception;

import com.nane.response.ErrorCode;

public class BizException extends RuntimeException {
    private int code;
    private String message;

    public BizException(String message) {
        super(message);
    }

    public BizException(ErrorCode errorCode) {
        this.code = errorCode.getCode();
        this.message = errorCode.getMsg();
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
