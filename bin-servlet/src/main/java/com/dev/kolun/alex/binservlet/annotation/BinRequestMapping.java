package com.dev.kolun.alex.binservlet.annotation;

import com.dev.kolun.alex.binservlet.Request;

import java.lang.annotation.*;

/**
 * Annotation for mapping requests message onto methods in {@link BinController @BinController}  classes
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BinRequestMapping {

    /**
     * The path strong mapping with request path {@link Request#getPath()} (e.g. {@code "oper/32"}).
     *
     * @return path for strong mapping
     */
    String path() default "";

}
