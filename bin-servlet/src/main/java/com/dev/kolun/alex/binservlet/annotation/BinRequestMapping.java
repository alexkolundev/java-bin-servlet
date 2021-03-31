package com.dev.kolun.alex.binservlet.annotation;

import java.lang.annotation.*;

@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface BinRequestMapping {

   String path() default "";

}
