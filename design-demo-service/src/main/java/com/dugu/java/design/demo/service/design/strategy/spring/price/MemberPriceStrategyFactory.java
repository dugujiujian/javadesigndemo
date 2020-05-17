package com.dugu.java.design.demo.service.design.strategy.spring.price;

import com.dugu.java.design.demo.service.design.strategy.spring.common.annotation.MemberGradeTag;
import com.dugu.java.design.demo.service.design.strategy.spring.common.annotation.TravelTypeTag;
import com.dugu.java.design.demo.service.design.strategy.spring.common.enums.MemberGradeEnum;
import com.dugu.java.design.demo.service.design.strategy.spring.common.enums.TravelTypeEnum;
import com.dugu.java.design.demo.service.design.strategy.spring.traveltype.TravelTypeBizHandlerStrategy;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 策略模式价格初始化类
 * @Author by cihun
 * @Date 2020/5/17 12:46 PM
 */
@Component
public class MemberPriceStrategyFactory implements ApplicationContextAware, InitializingBean {

    private static Map<MemberGradeEnum, MemberPriceStrategy> memberGradePriceMap = new HashMap<>();

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        Map<String, MemberPriceStrategy> taskMessageHandlerTypeMap = applicationContext.getBeansOfType(MemberPriceStrategy.class);
        taskMessageHandlerTypeMap.forEach((k, handler) -> {
            Class<? extends MemberPriceStrategy> aClass = handler.getClass();
            MemberGradeTag annotation = aClass.getAnnotation(MemberGradeTag.class);
            if (annotation != null) {
                memberGradePriceMap.put(annotation.value(), handler);
            }
        });
    }

    /**
     * 获取实例
     *
     * @param travelTypeEnum
     * @return
     */
    public MemberPriceStrategy getInstance(MemberGradeEnum travelTypeEnum) {
        MemberPriceStrategy handler = memberGradePriceMap.get(travelTypeEnum);
        if (handler == null) {
            return null;
        }
        return handler;
    }
}