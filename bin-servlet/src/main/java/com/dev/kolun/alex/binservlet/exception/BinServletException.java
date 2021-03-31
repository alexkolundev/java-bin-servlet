package com.dev.kolun.alex.binservlet.exception;

public class BinServletException extends RuntimeException {

    public BinServletException() {
        super();
    }

    public BinServletException(String message) {
        super(message);
    }

    public BinServletException(String message, Throwable cause) {
        super(message, cause);
    }

    public BinServletException(Throwable cause) {
        super(cause);
    }

    protected BinServletException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
