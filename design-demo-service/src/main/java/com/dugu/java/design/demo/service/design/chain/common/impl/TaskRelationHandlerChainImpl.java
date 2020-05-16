package com.dugu.java.design.demo.service.design.chain.common.impl;

import com.dugu.java.design.demo.service.design.chain.common.TaskRelationHandler;
import com.dugu.java.design.demo.service.design.chain.common.TaskRelationHandlerChain;
import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationRequest;
import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationResponse;

import java.util.List;

/**
 * @Description handler chain 递归处理
 * @Author by zhangliping
 * @Date 2020/5/16 10:46 PM
 */
public class TaskRelationHandlerChainImpl implements TaskRelationHandlerChain {
    /**
     * 处理类列表
     */
    List<TaskRelationHandler> handlerList;
    /**
     * 当前处理位点
     */
    int current;

    @Override
    public void handle(TaskRelationRequest request, TaskRelationResponse response) {
        current++;
        if (current < handlerList.size()) {
            TaskRelationHandler handler = handlerList.get(current);
            handler.handle(request, response, this);
        }
    }
}
