package com.dev.kolun.alex.binservlet.filter;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.dispatcher.Dispatcher;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;


import java.util.List;

import static org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE;

@Slf4j
@Service
@Scope(value = SCOPE_PROTOTYPE)
public class FilterChainProcessor implements FilterChain {

    private final Dispatcher dispatcher;
    private final List<Filter> filters;
    private final int count;
    private int pos = 0;

    @Autowired
    public FilterChainProcessor(Dispatcher dispatcher, List<Filter> filters) {
        this.dispatcher = dispatcher;
        this.filters = filters;
        this.count = filters.size();
    }

    public void doFilter(Request<?> request, Response<?> response) {
        if (pos < count) {
            filters.get(pos++).doFilter(request, response, this);
        } else {
            dispatcher.doDispatch(request, response);
        }
    }

}
