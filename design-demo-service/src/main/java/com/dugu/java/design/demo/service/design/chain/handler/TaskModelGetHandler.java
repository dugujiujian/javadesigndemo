package com.dugu.java.design.demo.service.design.chain.handler;

import com.dugu.java.design.demo.service.design.chain.common.TaskRelationHandler;
import com.dugu.java.design.demo.service.design.chain.common.TaskRelationHandlerChain;
import com.dugu.java.design.demo.service.design.chain.common.domain.TaskModel;
import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationRequest;
import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationResponse;
import org.springframework.stereotype.Component;

/**
 * @Description TaskModel数据处理handler
 * @Author by cihun
 * @Date 2020/5/16 11:07 PM
 */
@Component
public class TaskModelGetHandler implements TaskRelationHandler {
    @Override
    public void handle(TaskRelationRequest request, TaskRelationResponse response, TaskRelationHandlerChain dataHandlerChain) {
        TaskModel taskModel = new TaskModel();
        taskModel.setTaskId(request.getTaskId());
        taskModel.setTaskName("测试任务");
        // 返回taskModel
        response.setTaskModel(taskModel);
        // 跳转到下一个chain
        dataHandlerChain.handle(request, response);
    }

    @Override
    public void onException(TaskRelationRequest request, TaskRelationResponse handleResponse, Exception ex) {
        // 异常处理
    }

    @Override
    public int order() {
        return 1;
    }
}
