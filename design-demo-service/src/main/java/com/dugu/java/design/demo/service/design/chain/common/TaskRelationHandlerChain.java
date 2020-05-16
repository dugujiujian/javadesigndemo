package com.dugu.java.design.demo.service.design.chain.common;

import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationRequest;
import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationResponse;

/**
 * @Description 数据处理handler接口定义
 * @Author by zhangliping
 * @Date 2020/5/16 10:38 PM
 */
public interface TaskRelationHandlerChain {

    void handle(TaskRelationRequest request, TaskRelationResponse response);

}
