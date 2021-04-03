package com.dev.kolun.alex.binservlet.handler;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.annotation.BinController;
import com.dev.kolun.alex.binservlet.handler.dto.BeanMethod;
import org.mockito.Mockito;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.context.ApplicationContext;
import org.springframework.lang.Nullable;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class ContextHelper {

    public static BinServletHandleAdapter getServletHandleAdapter(Object object) {
        ApplicationContext applicationContext = Mockito.mock(ApplicationContext.class);
        Mockito.when(applicationContext.getBeansWithAnnotation(BinController.class))
                .thenReturn(getBeanMap(object));
        OngoingStubbing<Class<?>> when = Mockito.when(applicationContext.getType(object.getClass().getSimpleName()));
        when.thenReturn(object.getClass());

        return new BinServletHandleAdapter(applicationContext);
    }

    public static HashMap<String, Object> getBeanMap(Object... objects) {
        HashMap<String, Object> answer = new HashMap<>();
        for (Object obj : objects) {
            answer.put(obj.getClass().getSimpleName(), obj);
        }
        return answer;
    }


    @Nullable
    public static Map<String, BeanMethod> getRequestMapping(BinServletHandleAdapter servletHandleAdapter) {
        try {
            Field requestMapping = servletHandleAdapter.getClass().getDeclaredField("requestMapping");
            requestMapping.setAccessible(true);
            return (Map<String, BeanMethod>) requestMapping.get(servletHandleAdapter);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            return null;
        }
    }

    public static Request<Object> getRequest() {
        return new Request<>() {
            @Override
            public Object getRequest() {
                return null;
            }

            @Override
            public String getPath() {
                return null;
            }
        };
    }

    public static Response<Object> getResponse() {
        return new Response<>() {
            @Override
            public boolean isCommitted() {
                return false;
            }

            @Override
            public void setCommitted(boolean committed) {

            }

            @Override
            public Object getResponse() {
                return null;
            }

            @Override
            public void setResponse(Object response) {

            }
        };
    }

}
