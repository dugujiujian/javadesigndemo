package com.dugu.java.design.demo.service.design.strategy.spring.traveltype;

import com.dugu.java.design.demo.service.design.strategy.spring.common.annotation.TravelTypeTag;
import com.dugu.java.design.demo.service.design.strategy.spring.common.enums.TravelTypeEnum;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 策略初始化工厂类
 * @Author by cihun
 * @Date 2020/5/17 12:24 AM
 */
@Component
public class TravelTypeStrategyFactory implements ApplicationContextAware, InitializingBean {

    private static Map<TravelTypeEnum, TravelTypeBizHandlerStrategy> travelTypeMap = new HashMap<>();

    private ApplicationContext applicationContext;

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        Map<String, TravelTypeBizHandlerStrategy> taskMessageHandlerTypeMap = applicationContext.getBeansOfType(TravelTypeBizHandlerStrategy.class);
        taskMessageHandlerTypeMap.forEach((k, handler) -> {
            Class<? extends TravelTypeBizHandlerStrategy> aClass = handler.getClass();
            TravelTypeTag annotation = aClass.getAnnotation(TravelTypeTag.class);
            if (annotation != null) {
                TravelTypeEnum[] bizTypes = annotation.values();
                for (TravelTypeEnum bizType : bizTypes) {
                    travelTypeMap.put(bizType, handler);
                }

            }
        });
    }

    /**
     * 获取实例
     *
     * @param travelTypeEnum
     * @return
     */
    public TravelTypeBizHandlerStrategy getInstance(TravelTypeEnum travelTypeEnum) {
        TravelTypeBizHandlerStrategy handler = travelTypeMap.get(travelTypeEnum);
        if (handler == null) {
            return null;
        }
        return handler;
    }
}
