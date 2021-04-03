package com.dev.kolun.alex.binservlet.handler;

import com.dev.kolun.alex.binservlet.handler.controller.ControllerWithInterface;
import com.dev.kolun.alex.binservlet.handler.dto.BeanMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerWithInterfaceTest {

    @Test
    @DisplayName("Test interface/method1 method")
    public void interfaceMethod1() {
        ControllerWithInterface controllerWithInterface = new ControllerWithInterface();
        BinServletHandleAdapter servletHandleAdapter = ContextHelper.getServletHandleAdapter(controllerWithInterface);
        servletHandleAdapter.registerControllers();

        Map<String, BeanMethod> requestMapping = ContextHelper.getRequestMapping(servletHandleAdapter);

        Assertions.assertNotNull(requestMapping);
        BeanMethod beanMethod = requestMapping.get("interface/method1");
        Assertions.assertNotNull(beanMethod);
        Assertions.assertEquals(beanMethod.getBeanName(), controllerWithInterface.getClass().getSimpleName());
        Assertions.assertEquals(beanMethod.getBean(), controllerWithInterface);
        Assertions.assertTrue(
                Arrays.stream(controllerWithInterface.getClass().getMethods())
                        .collect(Collectors.toList())
                        .contains(beanMethod.getMethod()));
    }

    @Test
    @DisplayName("Test interface/method2 method")
    public void interfaceMethod2() {
        ControllerWithInterface controllerWithInterface = new ControllerWithInterface();
        BinServletHandleAdapter servletHandleAdapter = ContextHelper.getServletHandleAdapter(controllerWithInterface);
        servletHandleAdapter.registerControllers();

        Map<String, BeanMethod> requestMapping = ContextHelper.getRequestMapping(servletHandleAdapter);

        Assertions.assertNotNull(requestMapping);
        BeanMethod beanMethod = requestMapping.get("interface/method2");
        Assertions.assertNull(beanMethod);
    }

    @Test
    @DisplayName("Test interface/method3 method")
    public void interfaceMethod3() {
        ControllerWithInterface controllerWithInterface = new ControllerWithInterface();
        BinServletHandleAdapter servletHandleAdapter = ContextHelper.getServletHandleAdapter(controllerWithInterface);
        servletHandleAdapter.registerControllers();

        Map<String, BeanMethod> requestMapping = ContextHelper.getRequestMapping(servletHandleAdapter);

        Assertions.assertNotNull(requestMapping);
        BeanMethod beanMethod = requestMapping.get("interface/method3");
        Assertions.assertNull(beanMethod);
    }

    @Test
    @DisplayName("Test interface/method4 method")
    public void interfaceMethod4() {
        ControllerWithInterface controllerWithInterface = new ControllerWithInterface();
        BinServletHandleAdapter servletHandleAdapter = ContextHelper.getServletHandleAdapter(controllerWithInterface);
        servletHandleAdapter.registerControllers();

        Map<String, BeanMethod> requestMapping = ContextHelper.getRequestMapping(servletHandleAdapter);

        Assertions.assertNotNull(requestMapping);
        BeanMethod beanMethod = requestMapping.get("interface/method4");
        Assertions.assertNotNull(beanMethod);
        Assertions.assertEquals(beanMethod.getBeanName(), controllerWithInterface.getClass().getSimpleName());
        Assertions.assertEquals(beanMethod.getBean(), controllerWithInterface);
        Assertions.assertTrue(
                Arrays.stream(controllerWithInterface.getClass().getMethods())
                        .collect(Collectors.toList())
                        .contains(beanMethod.getMethod()));
    }


}
