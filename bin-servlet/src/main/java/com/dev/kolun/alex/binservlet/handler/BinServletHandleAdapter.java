package com.dev.kolun.alex.binservlet.handler;

import com.dev.kolun.alex.binservlet.Request;
import com.dev.kolun.alex.binservlet.Response;
import com.dev.kolun.alex.binservlet.annotation.BinController;
import com.dev.kolun.alex.binservlet.annotation.BinRequestMapping;
import com.dev.kolun.alex.binservlet.exception.BinServletException;
import com.dev.kolun.alex.binservlet.handler.dto.BeanMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotatedElementUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ClassUtils;

import javax.annotation.PostConstruct;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.*;

import static com.dev.kolun.alex.binservlet.util.TimeUtil.endTime;
import static com.dev.kolun.alex.binservlet.util.TimeUtil.startTime;
import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

/**
 * Service for controllers invocation
 * <p>
 * At the stage {@link PostConstruct } it registers all beans {@link BinController controller}
 * with methods {@link BinRequestMapping method}
 * <br>
 * <p>
 * Invoke bean method for end point {@link Request#getPath()} and passes request and response
 */
@Slf4j
@Service
public class BinServletHandleAdapter implements HandleAdapter {

    private final ApplicationContext applicationContext;
    private final Map<String, BeanMethod> requestMapping = new HashMap<>();

    @Autowired
    public BinServletHandleAdapter(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    @PostConstruct
    public void registerControllers() throws BeansException {
        applicationContext.getBeansWithAnnotation(BinController.class).forEach(this::register);
        log.debug("registerControllers: requestMapping=[{}]", requestMapping);
    }

    @Override
    public void handle(Request<?> request, Response<?> response) {
        log.debug("handle <- request=[{}], response=[{}]", request, response);
        long start = startTime();
        invoke(request.getPath(), request, response);
        log.debug("handle -> request=[{}], response=[{}], timeMs=[{}]", request, response, endTime(start));
    }

    private void invoke(String path, Request<?> request, Response<?> response) {
        log.debug("invoke <- path=[{}], request=[{}], response=[{}]", path, request, response);
        long start = startTime();
        BeanMethod beanMethod = requestMapping.get(path);
        if (isNull(beanMethod)) {
            throw new BinServletException(String.format("Handler not found for path: path=[%s]", path));
        }
        Method method = beanMethod.getMethod();
        try {
            method.invoke(beanMethod.getBean(), request, response);
        } catch (IllegalAccessException e) {
            throw new BinServletException(String.format("Invocation access exception for method: beanMethod=[%s]", beanMethod), e);
        } catch (InvocationTargetException e) {
            log.debug("Invocation target exception for method: beanMethod=[{}]", beanMethod);
            if (e.getTargetException() instanceof RuntimeException) {
                throw (RuntimeException) e.getTargetException();
            } else {
                throw new BinServletException(e.getTargetException());
            }
        }
        log.debug("invoke <- path=[{}], request=[{}], response=[{}], timeMs=[{}]", path, request, response, endTime(start));
    }

    private void register(String beanName, Object bean) throws BeansException {
        if (!beanName.startsWith("scopedTarget.") && isCandidateBean(beanName)) {
            Optional<Set<Method>> methods = detectHandlerMethods(bean);
            methods.ifPresent(methodSet -> methodSet.forEach(m -> {
                BinRequestMapping annotationRequest = m.getAnnotation(BinRequestMapping.class);
                BeanMethod v = new BeanMethod(beanName, bean, m);
                boolean nonNull = nonNull(requestMapping.putIfAbsent(annotationRequest.path(), v));
                if (nonNull) {
                    throw new BinServletException(String.format("Duplicate mapping handler: path=[%s], bean=[%s]", annotationRequest.path(), v));
                }
            }));
        }
    }

    private Optional<Set<Method>> detectHandlerMethods(Object handler) {
        Class<?> handlerType = handler.getClass();
        if (nonNull(handlerType)) {
            Class<?> userType = ClassUtils.getUserClass(handlerType);
            return Optional.of(findMethodByAnnotation(userType));
        }
        return Optional.empty();
    }

    private Set<Method> findMethodByAnnotation(Class<?> handler) {
        Set<Method> candidates = new HashSet<>();
        Method[] methods = handler.getMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(BinRequestMapping.class) && !method.isDefault() && !Modifier.isStatic(method.getModifiers())) {
                Class<?> returnType = method.getReturnType();
                if (checkReturnType(returnType)) {
                    candidates.add(method);
                }
            }
        }
        return candidates;
    }

    private boolean checkReturnType(Class<?> returnType) {
        return returnType.equals(Void.TYPE);
    }

    private boolean isCandidateBean(String beanName) {
        Class<?> beanType = null;
        try {
            beanType = applicationContext.getType(beanName);
        } catch (Exception ex) {
            if (log.isTraceEnabled()) {
                log.trace("Could not resolve type for bean '" + beanName + "'", ex);
            }
        }
        return nonNull(beanType) && isHandler(beanType);
    }

    private boolean isHandler(Class<?> beanType) {
        return AnnotatedElementUtils.hasAnnotation(beanType, BinController.class);
    }

}
