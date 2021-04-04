package com.dev.kolun.alex.binservlet.example.bean.interceptor;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.example.protocol.OperationWrapResponse;
import com.dev.kolun.alex.binservlet.handler.HandlerInterceptor;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value = 1)
public class FirstIsoInterceptor implements HandlerInterceptor {

    @Override
    public void before(Request<?> request, Response<?> response) {
        if (response instanceof OperationWrapResponse) {
            ((OperationWrapResponse) response).addAttribute("FirstIsoInterceptor before");
        }
    }

    @Override
    public void after(Request<?> request, Response<?> response) {
        if (response instanceof OperationWrapResponse) {
            ((OperationWrapResponse) response).addAttribute("FirstIsoInterceptor after");
        }
    }

    @Override
    public void afterException(Request<?> request, Response<?> response, Exception e) {
        if (response instanceof OperationWrapResponse) {
            ((OperationWrapResponse) response).addAttribute("FirstIsoInterceptor after exception");
        }
    }
}
