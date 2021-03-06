package com.dev.kolun.alex.binservlet.handler;

import com.dev.kolun.alex.binservlet.handler.controller.PojoController;
import com.dev.kolun.alex.binservlet.handler.dto.BeanMethod;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class PojoControllerTest {

    @Test
    public void pathPojoMethod1() {
        PojoController pojoController = new PojoController();
        BinServletHandleAdapter servletHandleAdapter = ContextHelper.getServletHandleAdapter(pojoController);
        servletHandleAdapter.registerControllers();

        Map<String, BeanMethod> requestMapping = ContextHelper.getRequestMapping(servletHandleAdapter);

        Assertions.assertNotNull(requestMapping);
        BeanMethod beanMethod = requestMapping.get("pojo/method1");
        Assertions.assertNotNull(beanMethod);
        Assertions.assertEquals(beanMethod.getBeanName(), pojoController.getClass().getSimpleName());
        Assertions.assertEquals(beanMethod.getBean(), pojoController);
        Assertions.assertTrue(
                Arrays.stream(pojoController.getClass().getMethods())
                        .collect(Collectors.toList())
                        .contains(beanMethod.getMethod()));
    }

    @Test
    public void pathPojoMethod2() {
        PojoController pojoController = new PojoController();
        BinServletHandleAdapter servletHandleAdapter = ContextHelper.getServletHandleAdapter(pojoController);
        servletHandleAdapter.registerControllers();

        Map<String, BeanMethod> requestMapping = ContextHelper.getRequestMapping(servletHandleAdapter);

        Assertions.assertNotNull(requestMapping);
        BeanMethod beanMethod = requestMapping.get("pojo/method2");
        Assertions.assertNull(beanMethod);
    }

    @Test
    public void pathPojoMethod3() {
        PojoController pojoController = new PojoController();
        BinServletHandleAdapter servletHandleAdapter = ContextHelper.getServletHandleAdapter(pojoController);
        servletHandleAdapter.registerControllers();

        Map<String, BeanMethod> requestMapping = ContextHelper.getRequestMapping(servletHandleAdapter);

        Assertions.assertNotNull(requestMapping);
        BeanMethod beanMethod = requestMapping.get("pojo/method3");
        Assertions.assertNull(beanMethod);
    }

}
