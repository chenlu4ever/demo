package com.example.demo.aop;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 数据字典的数字转汉字的自定义注解
 *
 * @author 10450
 * @date 2021/3/4 10:12
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface Dict {

    /**
     * 数据dataSource
     *
     * @return
     */
    String dictDataSource();

    /**
     * 返回put到json中的文本key
     * @return
     */
    String dictText() default "";
}
