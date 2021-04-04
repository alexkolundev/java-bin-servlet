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
    public void pathAbstractMethod1() {
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
    public void pathAbstractMethod2() {
        ControllerWithParent controllerWithParent = new ControllerWithParent();
        BinServletHandleAdapter servletHandleAdapter = ContextHelper.getServletHandleAdapter(controllerWithParent);
        servletHandleAdapter.registerControllers();

        Map<String, BeanMethod> requestMapping = ContextHelper.getRequestMapping(servletHandleAdapter);

        Assertions.assertNotNull(requestMapping);
        BeanMethod beanMethod = requestMapping.get("abstract/method2");
        Assertions.assertNull(beanMethod);
    }

    @Test
    public void pathAbstractMethod3() {
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
    public void pathAbstractMethod4() {
        ControllerWithParent controllerWithParent = new ControllerWithParent();
        BinServletHandleAdapter servletHandleAdapter = ContextHelper.getServletHandleAdapter(controllerWithParent);
        servletHandleAdapter.registerControllers();

        Map<String, BeanMethod> requestMapping = ContextHelper.getRequestMapping(servletHandleAdapter);

        Assertions.assertNotNull(requestMapping);
        BeanMethod beanMethod = requestMapping.get("abstract/method4");
        Assertions.assertNull(beanMethod);
    }

    @Test
    public void pathAbstractMethod5() {
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
