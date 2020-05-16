package com.dugu.java.design.demo.service.design.chain.common;

import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationRequest;
import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationResponse;

/**
 * @Description 任务和用户关系生成
 * @Author by cihun
 * @Date 2020/5/16 9:59 PM
 */
public interface TaskRelationHandlerService {
    /**
     * 创建任务和参与者关系
     *
     * @param request
     * @return
     */
    TaskRelationResponse createTaskUserRelation(TaskRelationRequest request);
}
