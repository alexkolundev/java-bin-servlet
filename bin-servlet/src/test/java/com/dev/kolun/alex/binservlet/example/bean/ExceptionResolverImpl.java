package com.dev.kolun.alex.binservlet.example.bean;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.dispatcher.ExceptionResolver;
import com.dev.kolun.alex.binservlet.example.protocol.OperationWrapRequest;
import com.dev.kolun.alex.binservlet.example.protocol.OperationWrapResponse;
import org.springframework.stereotype.Component;

@Component
public class ExceptionResolverImpl implements ExceptionResolver {

    @Override
    public void resolve(Request<?> request, Response<?> response, Exception exception) {
        resolve((OperationWrapRequest) request, (OperationWrapResponse) response, exception);
    }

    private void resolve(OperationWrapRequest request, OperationWrapResponse response, Exception exception) {
        response.addAttribute(exception.getMessage());
    }

}
