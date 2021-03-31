package com.dev.kolun.alex.binservlet.handler;


import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;

public interface HandleAdapter {

    void handle(Request<?> request, Response<?> response);

}
