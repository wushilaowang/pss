package com.oupu.pss.LogAop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Classname:LogAnnotation
 * Package:com.oupu.pss.LogAop
 * Description:
 *
 * @Data:2019/12/23 12:02
 * @Author:
 */

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface LogAnnotation {
    String value() default "operation";
}
