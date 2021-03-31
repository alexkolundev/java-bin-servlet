package com.dev.kolun.alex.binservlet.handler;


import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.annotation.BinController;
import com.dev.kolun.alex.binservlet.dispatcher.DispatcherBinServlet;
import com.dev.kolun.alex.binservlet.dispatcher.ExceptionResolver;

public interface HandlerChain {

    void applyBefore(Request<?> request, Response<?> response);

    void applyAfter(Request<?> request, Response<?> response);

    void applyAfterException(Request<?> request, Response<?> response, Exception e);

}
