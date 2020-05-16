package com.dugu.java.design.demo.service.design.strategy.handler;

import com.dugu.java.design.demo.service.design.strategy.common.TravelTypeBizHandlerStragety;
import com.dugu.java.design.demo.service.design.strategy.common.annotation.TravelTypeTag;
import com.dugu.java.design.demo.service.design.strategy.common.enums.TravelTypeEnum;
import com.dugu.java.design.demo.service.design.strategy.common.model.TravelTypeRequest;
import org.springframework.stereotype.Component;

/**
 * @Description 飞机旅行方式
 * @Author by zhangliping
 * @Date 2020/5/17 12:33 AM
 */
@Component
@TravelTypeTag(values = {TravelTypeEnum.PLANE})
public class PlaneTravelTypeStrategy implements TravelTypeBizHandlerStragety {
    @Override
    public String handler(TravelTypeRequest request) {
        return TravelTypeEnum.PLANE.getDesc();
    }
}
