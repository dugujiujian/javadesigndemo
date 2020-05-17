package com.dugu.java.design.demo.service.design.strategy.standard.price;

import com.dugu.java.design.demo.service.design.strategy.spring.price.handler.CooperMemberPriceStrategy;
import com.dugu.java.design.demo.service.design.strategy.spring.price.handler.NormalMemberPriceStrategy;
import com.dugu.java.design.demo.service.design.strategy.standard.PriceStrategyContext;
import org.junit.Test;

/**
 * @Description TODO
 * @Author by zhangliping
 * @Date 2020/5/17 12:58 PM
 */
public class MemberPriceStrategyTest {

    @Test
    public void test() {

        double basePrice = 100;

        NormalMemberPriceStrategy normalMemberPriceStrategy = new NormalMemberPriceStrategy();
        CooperMemberPriceStrategy cooperMemberPriceStrategy = new CooperMemberPriceStrategy();

        PriceStrategyContext test = new PriceStrategyContext(normalMemberPriceStrategy, basePrice);

        System.out.println("normal="+test.getPrice());

        test = new PriceStrategyContext(cooperMemberPriceStrategy, basePrice);

        System.out.println("cooper="+test.getPrice());
    }
}
