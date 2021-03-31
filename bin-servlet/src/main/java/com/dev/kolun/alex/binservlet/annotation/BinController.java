package com.dev.kolun.alex.binservlet.annotation;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 *  A annotation that is itself annotated with {@link Component @Component}
 *  <br>
 *  <p>
 *  Types that carry this annotation are treated as controllers where
 *  {@link BinRequestMapping @BinRequestMapping} methods assume are handlers
 *
 */
@Component
@Documented
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface BinController {

    /**
     * The value may indicate a suggestion for a logical component name,
     * to be turned into a Spring bean in case of an autodetected component.
     * @return the suggested component name, if any (or empty String otherwise)
     */
    @AliasFor(annotation = Component.class)
    String value() default "";
}

