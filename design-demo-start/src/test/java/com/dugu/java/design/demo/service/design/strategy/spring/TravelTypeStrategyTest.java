package com.dugu.java.design.demo.service.design.strategy.spring;

import com.dugu.java.design.demo.service.design.strategy.spring.common.TravelTypeBizHandlerStrategy;
import com.dugu.java.design.demo.service.design.strategy.spring.common.TravelTypeStrategyFactory;
import com.dugu.java.design.demo.service.design.strategy.spring.common.enums.TravelTypeEnum;
import com.dugu.java.design.demo.service.design.strategy.spring.common.model.TravelTypeRequest;
import com.dugu.java.design.demo.service.design.strategy.spring.handler.CarTravelTypeStrategy;
import com.dugu.java.design.demo.service.design.strategy.spring.handler.PlaneTravelTypeStrategy;
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
@ContextConfiguration(classes = TravelTypeStrategyTest.Config.class)
@RunWith(SpringRunner.class)
@SpringBootTest()
public class TravelTypeStrategyTest {

    @Autowired
    private TravelTypeStrategyFactory travelTypeStrategyFactory;


    @Test
    public void initTravelTypeStrategyFactory() {
        TravelTypeRequest request = new TravelTypeRequest();
        TravelTypeBizHandlerStrategy travelTypeBizHandlerStrategy = travelTypeStrategyFactory.getInstance(TravelTypeEnum.PLANE);
        Assert.assertEquals("飞机", travelTypeBizHandlerStrategy.handler(request));
        System.out.println(travelTypeBizHandlerStrategy.handler(request));

        travelTypeBizHandlerStrategy = travelTypeStrategyFactory.getInstance(TravelTypeEnum.CAR);
        Assert.assertEquals("汽车", travelTypeBizHandlerStrategy.handler(request));
        System.out.println(travelTypeBizHandlerStrategy.handler(request));
    }

    @Configuration
    static class Config {
        @Bean
        TravelTypeStrategyFactory travelTypeStrategyFactory() {
            return new TravelTypeStrategyFactory();
        }

        @Bean
        PlaneTravelTypeStrategy planeTravelTypeStrategy() {
            return new PlaneTravelTypeStrategy();
        }

        @Bean
        CarTravelTypeStrategy carTravelTypeStrategy() {
            return new CarTravelTypeStrategy();
        }
    }
}
