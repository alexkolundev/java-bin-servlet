package com.dev.kolun.alex.binservlet.handler;

import com.dev.kolun.alex.binservlet.handler.controller.ControllerWithParent;
import com.dev.kolun.alex.binservlet.handler.dto.BeanMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class ControllerWithParentTest {

    @Test
    @DisplayName("Test abstract/method1 method")
    public void abstractMethod1() {
        ControllerWithParent controllerWithParent = new ControllerWithParent();
        BinServletHandleAdapter servletHandleAdapter = ContextHelper.getServletHandleAdapter(controllerWithParent);
        servletHandleAdapter.registerControllers();

        Map<String, BeanMethod> requestMapping = ContextHelper.getRequestMapping(servletHandleAdapter);

        Assertions.assertNotNull(requestMapping);
        BeanMethod beanMethod = requestMapping.get("abstract/method1");
        Assertions.assertNotNull(beanMethod);
        Assertions.assertEquals(beanMethod.getBeanName(), controllerWithParent.getClass().getSimpleName());
        Assertions.assertEquals(beanMethod.getBean(), controllerWithParent);
        Assertions.assertTrue(
                Arrays.stream(controllerWithParent.getClass().getMethods())
                        .collect(Collectors.toList())
                        .contains(beanMethod.getMethod()));
    }

    @Test
    @DisplayName("Test abstract/method2 method")
    public void abstractMethod2() {
        ControllerWithParent controllerWithParent = new ControllerWithParent();
        BinServletHandleAdapter servletHandleAdapter = ContextHelper.getServletHandleAdapter(controllerWithParent);
        servletHandleAdapter.registerControllers();

        Map<String, BeanMethod> requestMapping = ContextHelper.getRequestMapping(servletHandleAdapter);

        Assertions.assertNotNull(requestMapping);
        BeanMethod beanMethod = requestMapping.get("abstract/method2");
        Assertions.assertNull(beanMethod);
    }

    @Test
    @DisplayName("Test abstract/method3 method")
    public void abstractMethod3() {
        ControllerWithParent controllerWithParent = new ControllerWithParent();
        BinServletHandleAdapter servletHandleAdapter = ContextHelper.getServletHandleAdapter(controllerWithParent);
        servletHandleAdapter.registerControllers();

        Map<String, BeanMethod> requestMapping = ContextHelper.getRequestMapping(servletHandleAdapter);

        Assertions.assertNotNull(requestMapping);
        BeanMethod beanMethod = requestMapping.get("abstract/method3");
        Assertions.assertNotNull(beanMethod);
        Assertions.assertEquals(beanMethod.getBeanName(), controllerWithParent.getClass().getSimpleName());
        Assertions.assertEquals(beanMethod.getBean(), controllerWithParent);
        Assertions.assertTrue(
                Arrays.stream(controllerWithParent.getClass().getMethods())
                        .collect(Collectors.toList())
                        .contains(beanMethod.getMethod()));
    }

    @Test
    @DisplayName("Test abstract/method4 method")
    public void abstractMethod4() {
        ControllerWithParent controllerWithParent = new ControllerWithParent();
        BinServletHandleAdapter servletHandleAdapter = ContextHelper.getServletHandleAdapter(controllerWithParent);
        servletHandleAdapter.registerControllers();

        Map<String, BeanMethod> requestMapping = ContextHelper.getRequestMapping(servletHandleAdapter);

        Assertions.assertNotNull(requestMapping);
        BeanMethod beanMethod = requestMapping.get("abstract/method4");
        Assertions.assertNull(beanMethod);
    }

    @Test
    @DisplayName("Test abstract/method5 method")
    public void abstractMethod5() {
        ControllerWithParent controllerWithParent = new ControllerWithParent();
        BinServletHandleAdapter servletHandleAdapter = ContextHelper.getServletHandleAdapter(controllerWithParent);
        servletHandleAdapter.registerControllers();

        Map<String, BeanMethod> requestMapping = ContextHelper.getRequestMapping(servletHandleAdapter);

        Assertions.assertNotNull(requestMapping);
        BeanMethod beanMethod = requestMapping.get("abstract/method5");
        Assertions.assertNotNull(beanMethod);
        Assertions.assertEquals(beanMethod.getBeanName(), controllerWithParent.getClass().getSimpleName());
        Assertions.assertEquals(beanMethod.getBean(), controllerWithParent);
        Assertions.assertTrue(
                Arrays.stream(controllerWithParent.getClass().getMethods())
                        .collect(Collectors.toList())
                        .contains(beanMethod.getMethod()));
    }



}
