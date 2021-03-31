package com.dev.kolun.alex.binservlet.bean.interceptor;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.handler.HandlerInterceptor;
import com.dev.kolun.alex.binservlet.protocol.OperationWrapResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value = 1)
public class FirstIsoInterceptor implements HandlerInterceptor {

    @Override
    public void before(Request<?> request, Response<?> response) {
        ((OperationWrapResponse) response).addAttribute("FirstIsoInterceptor before");
    }

    @Override
    public void after(Request<?> request, Response<?> response) {
        ((OperationWrapResponse) response).addAttribute("FirstIsoInterceptor after");
    }

    @Override
    public void afterException(Request<?> request, Response<?> response, Exception e) {
        ((OperationWrapResponse) response).addAttribute("FirstIsoInterceptor after exception");
    }
}
