package com.dugu.java.design.demo.service.design.strategy.spring.price;

import com.dugu.java.design.demo.service.design.strategy.spring.common.enums.MemberGradeEnum;
import com.dugu.java.design.demo.service.design.strategy.spring.common.enums.TravelTypeEnum;
import com.dugu.java.design.demo.service.design.strategy.spring.common.model.TravelTypeRequest;
import com.dugu.java.design.demo.service.design.strategy.spring.price.handler.CooperMemberPriceStrategy;
import com.dugu.java.design.demo.service.design.strategy.spring.price.handler.NormalMemberPriceStrategy;
import com.dugu.java.design.demo.service.design.strategy.spring.traveltype.TravelTypeBizHandlerStrategy;
import com.dugu.java.design.demo.service.design.strategy.spring.traveltype.TravelTypeStrategyFactory;
import com.dugu.java.design.demo.service.design.strategy.spring.traveltype.handler.CarTravelTypeStrategy;
import com.dugu.java.design.demo.service.design.strategy.spring.traveltype.handler.PlaneTravelTypeStrategy;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @Description 策略模式测试代码
 * @Author by cihun
 * @Date 2020/5/17 12:36 AM
 */
@ContextConfiguration(classes = MemberPriceStrategyTest.Config.class)
@RunWith(SpringRunner.class)
@SpringBootTest()
public class MemberPriceStrategyTest {

    @Autowired
    private MemberPriceStrategyFactory memberPriceStrategyFactory;


    @Test
    public void initTravelTypeStrategyFactory() {
        double basePrice = 100;
        MemberPriceStrategy priceStrategy = memberPriceStrategyFactory.getInstance(MemberGradeEnum.NORMAL);
        Assert.assertTrue(100 == priceStrategy.calcPrice(basePrice));
        System.out.println(priceStrategy.calcPrice(basePrice));

        priceStrategy = memberPriceStrategyFactory.getInstance(MemberGradeEnum.COPPER);
        Assert.assertTrue(90 == priceStrategy.calcPrice(basePrice));
        System.out.println(priceStrategy.calcPrice(basePrice));
    }

    @Configuration
    static class Config {
        @Bean
        MemberPriceStrategyFactory memberPriceStrategyFactory() {
            return new MemberPriceStrategyFactory();
        }

        @Bean
        NormalMemberPriceStrategy normalMemberPriceStrategy() {
            return new NormalMemberPriceStrategy();
        }

        @Bean
        CooperMemberPriceStrategy cooperMemberPriceStrategy() {
            return new CooperMemberPriceStrategy();
        }
    }
}
