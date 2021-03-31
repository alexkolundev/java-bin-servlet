package com.dev.kolun.alex.binservlet;

import com.dev.kolun.alex.binservlet.filter.Filter;
import com.dev.kolun.alex.binservlet.handler.HandlerInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Collections;
import java.util.List;


@Configuration
public class BinAutoConfiguration {

    @Bean
    @ConditionalOnBean(value = HandlerInterceptor.class)
    public List<HandlerInterceptor> interceptors() {
        return Collections.emptyList();
    }

    @Bean
    @ConditionalOnBean(value = Filter.class)
    public List<Filter> filters() {
        return Collections.emptyList();
    }

}
