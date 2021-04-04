package com.dev.kolun.alex.binservlet.example.bean;

import com.dev.kolun.alex.binservlet.example.bean.service.OperationService;
import com.dev.kolun.alex.binservlet.example.bean.service.SecurityService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan(basePackages = "com.dev.kolun.alex.binservlet")
public class TestConfiguration {

    @Bean
    public SecurityService securityService(){
        return Mockito.mock(SecurityService.class);
    }

    @Bean
    public OperationService operationService(){
        return Mockito.mock(OperationService.class);
    }


}
