package com.dugu.java.design.demo.service.design.strategy.spring.traveltype.handler;

import com.dugu.java.design.demo.service.design.strategy.spring.traveltype.TravelTypeBizHandlerStrategy;
import com.dugu.java.design.demo.service.design.strategy.spring.common.annotation.TravelTypeTag;
import com.dugu.java.design.demo.service.design.strategy.spring.common.enums.TravelTypeEnum;
import com.dugu.java.design.demo.service.design.strategy.spring.common.model.TravelTypeRequest;
import org.springframework.stereotype.Component;

/**
 * @Description 汽车旅行方式
 * @Author by cihun
 * @Date 2020/5/17 12:41 AM
 */

@Component
@TravelTypeTag(values = {TravelTypeEnum.CAR})
public class CarTravelTypeStrategy implements TravelTypeBizHandlerStrategy {
    @Override
    public String handler(TravelTypeRequest request) {
        return TravelTypeEnum.CAR.getDesc();
    }
}
