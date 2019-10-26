package com.wanghui.sip2model.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @auther wanghui
 * @create 2018-11-13 0:36
 * @Description  自定义注解，value值为sip2的命令编码
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface Command {
    String value();
}
