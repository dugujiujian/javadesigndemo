package com.dugu.java.design.demo.service.design.strategy.spring.traveltype;

import com.dugu.java.design.demo.service.design.strategy.spring.common.model.TravelTypeRequest;

/**
 * @Description 策略模式接口定义
 * @Author by cihun
 * @Date 2020/5/17 12:27 AM
 */
public interface TravelTypeBizHandlerStrategy {

    /**
     * 策略选择
     *
     * @param request
     * @return
     */
    String handler(TravelTypeRequest request);
}
