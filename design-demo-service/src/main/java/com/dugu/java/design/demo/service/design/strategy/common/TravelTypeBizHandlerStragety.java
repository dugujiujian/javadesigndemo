package com.dugu.java.design.demo.service.design.strategy.common;

import com.dugu.java.design.demo.service.design.strategy.common.model.TravelTypeRequest;

/**
 * @Description TODO
 * @Author by zhangliping
 * @Date 2020/5/17 12:27 AM
 */
public interface TravelTypeBizHandlerStragety {

    String handler(TravelTypeRequest request);
}
