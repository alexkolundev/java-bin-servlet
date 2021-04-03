package com.dev.kolun.alex.binservlet.example.bean.filter;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.filter.Filter;
import com.dev.kolun.alex.binservlet.filter.FilterChain;
import com.dev.kolun.alex.binservlet.example.protocol.OperationWrapResponse;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Service;

@Service
@Order(value = 1)
public class FirstFilter implements Filter {

    @Override
    public void doFilter(Request<?> request, Response<?> response, FilterChain chain) {
        try {
            ((OperationWrapResponse) response).addAttribute("FirstFilter");
            chain.doFilter(request, response);
        } finally {
            ((OperationWrapResponse) response).addAttribute("FirstFilter finally");
        }
    }
}
