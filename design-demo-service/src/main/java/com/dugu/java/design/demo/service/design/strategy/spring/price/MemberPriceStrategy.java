package com.dugu.java.design.demo.service.design.strategy.spring.price;

/**
 * @Description 获取会员价格接口定义
 * @Author by cihun
 * @Date 2020/5/17 11:51 AM
 */
public interface MemberPriceStrategy {

    /**
     * 获取会员最终价格
     *
     * @param basePrice
     * @return
     */
    double calcPrice(double basePrice);
}
