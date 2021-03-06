package com.yangyu.common.exception;

import java.io.Serializable;

/** 没有访问权限 */
public class ForbiddenException extends RuntimeException implements Serializable {
    private static final long serialVersionUID = 1L;

    public ForbiddenException() {
        super("没有权限");
    }
    public ForbiddenException(String msg) {
        super(msg);
    }

    @Override
    public Throwable fillInStackTrace() {
        return this;
    }
}
