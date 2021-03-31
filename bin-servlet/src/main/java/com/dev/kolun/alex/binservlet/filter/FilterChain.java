package com.dev.kolun.alex.binservlet.filter;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;

public interface FilterChain {

    void doFilter(Request<?> request, Response<?> response);

}
