package com.dev.kolun.alex.binservlet.example.bean.interceptor;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.example.bean.service.SecurityService;
import com.dev.kolun.alex.binservlet.example.protocol.OperationWrapRequest;
import com.dev.kolun.alex.binservlet.example.protocol.OperationWrapResponse;
import com.dev.kolun.alex.binservlet.handler.HandlerInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value = 2)
public class SecondIsoInterceptor implements HandlerInterceptor {

    private final SecurityService securityService;

    @Autowired
    public SecondIsoInterceptor(SecurityService securityService) {
        this.securityService = securityService;
    }

    @Override
    public void before(Request<?> request, Response<?> response) {
        if (request instanceof OperationWrapRequest) {
            ((OperationWrapResponse) response).addAttribute("SecondIsoInterceptor before");
            securityService.checkToken(((OperationWrapRequest) request).getRequest().getToken());
        }
    }

    @Override
    public void after(Request<?> request, Response<?> response) {
        if (response instanceof OperationWrapResponse) {
            ((OperationWrapResponse) response).addAttribute("SecondIsoInterceptor after");
        }
    }

    @Override
    public void afterException(Request<?> request, Response<?> response, Exception e) {
        if (response instanceof OperationWrapResponse) {
            ((OperationWrapResponse) response).addAttribute("SecondIsoInterceptor after exception");
        }
    }
}
