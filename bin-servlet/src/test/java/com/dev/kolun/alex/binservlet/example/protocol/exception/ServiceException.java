package com.dev.kolun.alex.binservlet.example.protocol.exception;

import com.dev.kolun.alex.binservlet.example.protocol.dto.ResponseData;
import lombok.Getter;

public class ServiceException extends RuntimeException {

    @Getter
    private final ResponseData responseData;

    public ServiceException(int status, String message) {
        super(message);
        this.responseData = new ResponseData(status, getMessage());
    }
}
