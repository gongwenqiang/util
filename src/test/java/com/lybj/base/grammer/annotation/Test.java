package com.lybj.base.grammer.annotation;

import java.lang.annotation.*;

/**
 * Created by Administrator on 2018/1/14.
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
public @interface Test {
    public String test() default "";
}
