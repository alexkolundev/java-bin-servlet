package com.dev.kolun.alex.binservlet.example.bean;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.dispatcher.ExceptionResolver;
import com.dev.kolun.alex.binservlet.example.protocol.dto.HasResponseData;
import com.dev.kolun.alex.binservlet.example.protocol.dto.ResponseData;
import com.dev.kolun.alex.binservlet.example.protocol.exception.ServiceException;
import com.dev.kolun.alex.binservlet.example.protocol.exception.SystemException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ExceptionResolverImpl implements ExceptionResolver {

    @Override
    public void resolve(Request<?> request, Response<?> response, Exception e) {
        if (response.getResponse() instanceof HasResponseData) {
            if (e instanceof ServiceException) {
                ((HasResponseData)response.getResponse()).setResponseData(((ServiceException)e).getResponseData());
            } else {
                ((HasResponseData)response.getResponse()).setResponseData(new ResponseData(500, "Unknown error"));
            }
        } else {
            log.error("Unknown error and type response: request=[{}], response=[{}]", request, response, e);
            throw new SystemException(e);
        }

    }

}
