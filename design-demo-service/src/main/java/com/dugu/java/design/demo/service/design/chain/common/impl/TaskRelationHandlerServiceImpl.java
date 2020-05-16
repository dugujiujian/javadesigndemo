package com.dugu.java.design.demo.service.design.chain.common.impl;

import com.dugu.java.design.demo.service.design.chain.common.TaskRelationHandler;
import com.dugu.java.design.demo.service.design.chain.common.TaskRelationHandlerService;
import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationRequest;
import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @Description handler  数据初始化
 * @Author by zhangliping
 * @Date 2020/5/16 10:51 PM
 */
@Component
public class TaskRelationHandlerServiceImpl implements TaskRelationHandlerService, ApplicationContextAware, InitializingBean {


    private static final Logger LOGGER = LoggerFactory.getLogger(TaskRelationHandlerServiceImpl.class);

    private ApplicationContext applicationContext;

    private List<TaskRelationHandler> handlerList;

    @Override
    public TaskRelationResponse createTaskUserRelation(TaskRelationRequest request) {

        TaskRelationResponse response = new TaskRelationResponse();
        TaskRelationHandlerChainImpl dataHandlerChain = new TaskRelationHandlerChainImpl();
        dataHandlerChain.handlerList = handlerList;
        dataHandlerChain.current = 0;
        if (!handlerList.isEmpty()) {
            TaskRelationHandler handler = handlerList.get(0);
            try {
                handler.handle(request, response, dataHandlerChain);
            } catch (Exception ex) {
                LOGGER.error("[TaskRelationHandlerService] taskId:{} @ {} step got exception", request.getTaskId(), dataHandlerChain.current, ex);
                handlerList.forEach(dh -> dh.onException(request, response, ex));
            }
        }

        return response;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        this.applicationContext = applicationContext;
    }

    @Override
    public void afterPropertiesSet() {
        Map<String, TaskRelationHandler> handlerMap = applicationContext.getBeansOfType(TaskRelationHandler.class);
        handlerList = handlerMap.entrySet().stream()
                .map(Map.Entry::getValue)
                .sorted(Comparator.comparingInt(TaskRelationHandler::order))
                .collect(Collectors.toList());
    }
}
