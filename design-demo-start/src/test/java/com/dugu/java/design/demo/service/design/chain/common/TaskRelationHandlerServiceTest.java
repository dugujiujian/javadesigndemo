package com.dugu.java.design.demo.service.design.chain.common;

import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationRequest;
import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationResponse;
import com.dugu.java.design.demo.service.design.chain.common.impl.TaskRelationHandlerServiceImpl;
import com.dugu.java.design.demo.service.design.chain.handler.TaskModelGetHandler;
import com.dugu.java.design.demo.service.design.chain.handler.TaskModelPrintHandler;
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
 * @Description 责任链模式测试类
 * @Author by zhangliping
 * @Date 2020/5/16 11:17 PM
 */
@ContextConfiguration(classes = TaskRelationHandlerServiceTest.Config.class)
@RunWith(SpringRunner.class)
@SpringBootTest()
public class TaskRelationHandlerServiceTest {

    @Autowired
    private TaskRelationHandlerService taskRelationHandlerService;


    @Test
    public void initTaskRelationHandlerService() {
        TaskRelationRequest request = new TaskRelationRequest();
        request.setTaskId(120000L);
        TaskRelationResponse response = taskRelationHandlerService.createTaskUserRelation(request);
        Assert.assertNotNull(response);
        Assert.assertNotNull(response.getTaskModel());
        Assert.assertEquals("测试任务",response.getTaskModel().getTaskName());
        System.out.println(response);
    }

    @Configuration
    static class Config {
        @Bean
        TaskRelationHandlerService taskRelationHandlerService() {
            return new TaskRelationHandlerServiceImpl();
        }

        @Bean
        TaskRelationHandler taskModelGetHandler() {
            return new TaskModelGetHandler();
        }

        @Bean
        TaskRelationHandler taskModelPrintHandler() {
            return new TaskModelPrintHandler();
        }
    }

}
