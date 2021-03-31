package com.dev.kolun.alex.binservlet.bean.interceptor;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.handler.HandlerInterceptor;
import com.dev.kolun.alex.binservlet.protocol.OperationWrapResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value = 2)
public class SecondIsoInterceptor implements HandlerInterceptor {

    @Override
    public void before(Request<?> request, Response<?> response) {
        ((OperationWrapResponse) response).addAttribute("SecondIsoInterceptor before");
    }

    @Override
    public void after(Request<?> request, Response<?> response) {
        ((OperationWrapResponse) response).addAttribute("SecondIsoInterceptor after");
    }

    @Override
    public void afterException(Request<?> request, Response<?> response, Exception e) {
        ((OperationWrapResponse) response).addAttribute("SecondIsoInterceptor after exception");
    }
}
