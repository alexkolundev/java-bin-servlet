package com.dev.kolun.alex.binservlet.dispatcher;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.handler.HandleAdapter;
import com.dev.kolun.alex.binservlet.handler.HandlerChain;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.dev.kolun.alex.binservlet.util.TimeUtil.endTime;
import static com.dev.kolun.alex.binservlet.util.TimeUtil.startTime;

@Slf4j
@Service
public class DispatcherBinServlet implements Dispatcher {

    private final ExceptionResolver exceptionResolver;
    private final HandlerChain handlerChain;
    private final HandleAdapter handleAdapter;

    @Autowired
    public DispatcherBinServlet(HandleAdapter handleAdapter,
                                HandlerChain handlerChain,
                                ExceptionResolver exceptionResolver) {
        this.exceptionResolver = exceptionResolver;
        this.handlerChain = handlerChain;
        this.handleAdapter = handleAdapter;
    }

    @Override
    public void doDispatch(Request<?> request, Response<?> response) {
        log.debug("doDispatch <- request=[{}], response=[{}]", request, response);
        long start = startTime();
        try {
            handlerChain.applyBefore(request, response);

            handleAdapter.handle(request, response);

            handlerChain.applyAfter(request, response);

            response.setCommitted(true);
        } catch (Exception e) {
            exceptionResolver.resolve(request, response, e);
            handlerChain.applyAfterException(request, response, e);
        }
        log.debug("doDispatch -> request=[{}], response=[{}], timeMs=[{}]", request, response, endTime(start));
    }
}
