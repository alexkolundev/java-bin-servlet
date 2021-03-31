package com.dev.kolun.alex.binservlet.handler;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;

public interface HandlerInterceptor {

    default void before(Request<?> request, Response<?> response) {
    }

    default void after(Request<?> request, Response<?> response) {
    }

    default void afterException(Request<?> request, Response<?> response, Exception e) {
    }

}
