package com.dugu.java.design.demo.service.design.strategy.spring.common.annotation;

import com.dugu.java.design.demo.service.design.strategy.spring.common.enums.MemberGradeEnum;
import com.dugu.java.design.demo.service.design.strategy.spring.common.enums.TravelTypeEnum;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @Description 会员价格注解定义
 * @Author by cihun
 * @Date 2020/5/17 12:27 PM
 */

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface MemberGradeTag {
    MemberGradeEnum value();
}

