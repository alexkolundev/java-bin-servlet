package com.dev.kolun.alex.binservlet.dispatcher;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.filter.FilterChainProcessor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.ObjectFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static com.dev.kolun.alex.binservlet.util.TimeUtil.endTime;
import static com.dev.kolun.alex.binservlet.util.TimeUtil.startTime;

@Slf4j
@Service
public class BinServletProcessor implements BinServlet {

    private final ObjectFactory<FilterChainProcessor> filterChainProcessor;

    @Autowired
    public BinServletProcessor(ObjectFactory<FilterChainProcessor> filterChainProcessor) {
        this.filterChainProcessor = filterChainProcessor;
    }

    @Override
    public void service(Request<?> request, Response<?> response) {
        log.info("service <- request=[{}], response=[{}]", request, response);
        long start = startTime();
        filterChainProcessor.getObject().doFilter(request, response);
        log.info("service -> request=[{}], response=[{}], timeMs=[{}]", request, response, endTime(start));
    }
}
