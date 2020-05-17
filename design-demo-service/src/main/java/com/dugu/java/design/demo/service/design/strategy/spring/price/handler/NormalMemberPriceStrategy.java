package com.dugu.java.design.demo.service.design.strategy.spring.price.handler;

import com.dugu.java.design.demo.service.design.strategy.spring.common.annotation.MemberGradeTag;
import com.dugu.java.design.demo.service.design.strategy.spring.common.enums.MemberGradeEnum;
import com.dugu.java.design.demo.service.design.strategy.spring.price.MemberPriceStrategy;
import org.springframework.stereotype.Component;

/**
 * @Description 普通用户价格
 * @Author by cihun
 * @Date 2020/5/17 12:27 PM
 */
@Component
@MemberGradeTag(MemberGradeEnum.NORMAL)
public class NormalMemberPriceStrategy implements MemberPriceStrategy {
    @Override
    public double calcPrice(double basePrice) {
        return basePrice * MemberGradeEnum.NORMAL.getDiscount();
    }
}
