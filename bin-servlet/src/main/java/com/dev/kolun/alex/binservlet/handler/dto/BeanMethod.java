package com.dev.kolun.alex.binservlet.handler.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.lang.reflect.Method;

@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BeanMethod {

    private String beanName;
    private Object bean;
    private Method method;

}
