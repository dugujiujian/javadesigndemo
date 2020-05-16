package com.dugu.java.design.demo.service.design.strategy.common.annotation;

import com.dugu.java.design.demo.service.design.strategy.common.enums.TravelTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 出行方式注解接口
 * @Author by cihun
 * @Date 2020/5/17 12:18 AM
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface TravelTypeTag {
    TravelTypeEnum[] values();
}








