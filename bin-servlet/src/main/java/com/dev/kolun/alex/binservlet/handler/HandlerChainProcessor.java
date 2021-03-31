package com.dev.kolun.alex.binservlet.handler;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

import static com.dev.kolun.alex.binservlet.util.TimeUtil.endTime;
import static com.dev.kolun.alex.binservlet.util.TimeUtil.startTime;

@Slf4j
@Service
public class HandlerChainProcessor implements HandlerChain {

    private final List<HandlerInterceptor> interceptors;

    @Autowired
    public HandlerChainProcessor(List<HandlerInterceptor> interceptors) {
        this.interceptors = interceptors;
    }

    @Override
    public void applyBefore(Request<?> request, Response<?> response) {
        log.debug("applyBefore <- request=[{}], response=[{}]", request, response);
        long start = startTime();
        for (int i = 0; i < interceptors.size(); i++) {
            HandlerInterceptor handlerInterceptor = interceptors.get(i);
            if (log.isDebugEnabled()) {
                log.debug("Invoke before by interceptor: index=[{}], interceptor=[{}]", i, handlerInterceptor.getClass().getSimpleName());
            }
            handlerInterceptor.before(request, response);
        }
        log.debug("applyBefore -> request=[{}], response=[{}], timeMs=[{}]", request, response, endTime(start));
    }

    @Override
    public void applyAfter(Request<?> request, Response<?> response) {
        log.debug("applyAfter <- request=[{}], response=[{}]", request, response);
        long start = startTime();
        for (int i = interceptors.size() - 1; i >= 0; --i) {
            HandlerInterceptor handlerInterceptor = interceptors.get(i);
            if (log.isDebugEnabled()) {
                log.debug("Invoke after by interceptor: index=[{}], interceptor=[{}]", i, handlerInterceptor.getClass().getSimpleName());
            }
            handlerInterceptor.after(request, response);
        }
        log.debug("applyAfter -> request=[{}], response=[{}], timeMs=[{}]", request, response, endTime(start));
    }

    @Override
    public void applyAfterException(Request<?> request, Response<?> response, Exception e) {
        log.debug("applyAfterException <- request=[{}], response=[{}]", request, response);
        long start = startTime();
        for (int i = interceptors.size() - 1; i >= 0; --i) {
            HandlerInterceptor handlerInterceptor = interceptors.get(i);
            if (log.isDebugEnabled()) {
                log.debug("Invoke after exception by interceptor: index=[{}], interceptor=[{}]", i, handlerInterceptor.getClass().getSimpleName());
            }
            interceptors.get(i).afterException(request, response, e);
        }
        log.debug("applyAfterException -> request=[{}], response=[{}], timeMs=[{}]", request, response, endTime(start));
    }

}
