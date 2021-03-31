package com.dev.kolun.alex.binservlet.handler;


import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.annotation.BinController;

/**
 *  Service for controllers invocation
 */
public interface HandleAdapter {

    /**
     * The promises to process the request and return a response from the bean {@link BinController}
     *
     * @param request request message
     * @param response response message
     */
    void handle(Request<?> request, Response<?> response);

}
