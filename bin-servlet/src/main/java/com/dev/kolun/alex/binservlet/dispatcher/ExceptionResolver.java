package com.dev.kolun.alex.binservlet.dispatcher;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;

public interface ExceptionResolver {

    void resolve(Request<?> request, Response<?> response, Exception exception);

}
