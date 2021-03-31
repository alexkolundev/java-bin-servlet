package com.dev.kolun.alex.binservlet.dispatcher;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;

public interface BinServlet {

    void service(Request<?> request, Response<?> response);

}
