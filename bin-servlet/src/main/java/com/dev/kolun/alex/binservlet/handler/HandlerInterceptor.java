package com.dev.kolun.alex.binservlet.handler;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.annotation.BinController;
import com.dev.kolun.alex.binservlet.dispatcher.DispatcherBinServlet;
import com.dev.kolun.alex.binservlet.dispatcher.ExceptionResolver;

/**
 * A HandlerChain is an object that processes requests and responses sequentially.
 * <br>
 * <p>
 * Before executing the controller method, the methods of all interceptors are executed
 *
 * A simplified analogue of the HandlerInterceptor in org.springframework.web.servlet.HandlerInterceptor
 */
public interface HandlerInterceptor {

    /**
     * Processing before sending to the {@link BinController controller}
     *
     * @param request request message
     * @param response response message
     */
    default void before(Request<?> request, Response<?> response) {
    }

    /**
     * Processing after sending to the {@link BinController controller}
     *
     * @param request request message
     * @param response response message
     */
    default void after(Request<?> request, Response<?> response) {
    }

    /**
     * Processing after {@link ExceptionResolver#resolve(Request, Response, Exception)} },
     * if an exception was thrown in processing {@link DispatcherBinServlet#doDispatch(Request, Response)}
     *
     * @param request request message
     * @param response response message
     * @param e exception
     */
    default void afterException(Request<?> request, Response<?> response, Exception e) {
    }

}
