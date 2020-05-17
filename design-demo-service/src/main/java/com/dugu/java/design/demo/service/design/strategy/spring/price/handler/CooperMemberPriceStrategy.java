package com.dugu.java.design.demo.service.design.strategy.spring.price.handler;

import com.dugu.java.design.demo.service.design.strategy.spring.common.annotation.MemberGradeTag;
import com.dugu.java.design.demo.service.design.strategy.spring.common.enums.MemberGradeEnum;
import com.dugu.java.design.demo.service.design.strategy.spring.price.MemberPriceStrategy;
import org.springframework.stereotype.Component;

/**
 * @Description 青铜价格
 * @Author by cihun
 * @Date 2020/5/17 12:39 PM
 */
@Component
@MemberGradeTag(MemberGradeEnum.COPPER)
public class CooperMemberPriceStrategy implements MemberPriceStrategy {
    @Override
    public double calcPrice(double basePrice) {
        return basePrice * MemberGradeEnum.COPPER.getDiscount();
    }
}
