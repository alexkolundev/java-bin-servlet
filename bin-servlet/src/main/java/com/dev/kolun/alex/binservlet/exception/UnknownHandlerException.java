package com.dev.kolun.alex.binservlet.exception;

public class UnknownHandlerException extends BinServletException {

    public UnknownHandlerException() {
    }

    public UnknownHandlerException(String message) {
        super(message);
    }

    public UnknownHandlerException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnknownHandlerException(Throwable cause) {
        super(cause);
    }

    public UnknownHandlerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
