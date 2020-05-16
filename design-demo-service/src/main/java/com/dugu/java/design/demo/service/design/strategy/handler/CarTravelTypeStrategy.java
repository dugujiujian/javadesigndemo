package com.dugu.java.design.demo.service.design.strategy.handler;

import com.dugu.java.design.demo.service.design.strategy.common.TravelTypeBizHandlerStragety;
import com.dugu.java.design.demo.service.design.strategy.common.annotation.TravelTypeTag;
import com.dugu.java.design.demo.service.design.strategy.common.enums.TravelTypeEnum;
import com.dugu.java.design.demo.service.design.strategy.common.model.TravelTypeRequest;
import org.springframework.stereotype.Component;

/**
 * @Description TODO
 * @Author by zhangliping
 * @Date 2020/5/17 12:41 AM
 */

@Component
@TravelTypeTag(values = {TravelTypeEnum.CAR})
public class CarTravelTypeStrategy implements TravelTypeBizHandlerStragety {
    @Override
    public String handler(TravelTypeRequest request) {
        return TravelTypeEnum.CAR.getDesc();
    }
}
