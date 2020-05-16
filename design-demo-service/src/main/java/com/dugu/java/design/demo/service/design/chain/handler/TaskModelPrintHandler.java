package com.dugu.java.design.demo.service.design.chain.handler;

import com.dugu.java.design.demo.service.design.chain.common.TaskRelationHandler;
import com.dugu.java.design.demo.service.design.chain.common.TaskRelationHandlerChain;
import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationRequest;
import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @Description 打印日志
 * @Author by zhangliping
 * @Date 2020/5/16 11:14 PM
 */
@Component
public class TaskModelPrintHandler implements TaskRelationHandler {

    private static final Logger LOGGER = LoggerFactory.getLogger(TaskModelPrintHandler.class);


    @Override
    public void handle(TaskRelationRequest request, TaskRelationResponse response, TaskRelationHandlerChain dataHandlerChain) {
        LOGGER.info("TaskModel={}",response.getTaskModel());
        dataHandlerChain.handle(request,response);
    }

    @Override
    public void onException(TaskRelationRequest request, TaskRelationResponse response, Exception ex) {
        // 异常处理
    }

    @Override
    public int order() {
        return 99;
    }
}