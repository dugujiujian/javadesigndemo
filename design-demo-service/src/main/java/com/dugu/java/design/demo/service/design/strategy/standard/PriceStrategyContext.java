package com.dugu.java.design.demo.service.design.strategy.standard;

import com.dugu.java.design.demo.service.design.strategy.spring.price.MemberPriceStrategy;

/**
 * @Description 策略模式标准版 实现
 * @Author by cihun
 * @Date 2020/5/17 11:47 AM
 */
public class PriceStrategyContext {

    private MemberPriceStrategy memberPriceStrategy;

    private double basePrice;

    public PriceStrategyContext(MemberPriceStrategy memberPriceStrategy, double basePrice) {
        this.memberPriceStrategy = memberPriceStrategy;
        this.basePrice = basePrice;
    }

    public double getPrice() {
        return memberPriceStrategy.calcPrice(this.basePrice);
    }


}
