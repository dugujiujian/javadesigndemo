package com.dugu.java.design.demo.service.design.chain.common;

import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationRequest;
import com.dugu.java.design.demo.service.design.chain.common.domain.TaskRelationResponse;

/**
 * @Description 数据处理handler 接口定义
 * @Author by cihun
 * @Date 2020/5/16 10:38 PM
 */
public interface TaskRelationHandler {
    /**
     * 处理当前的TaskModel，如果有需要返回的值可以放置在response，需要调用后续的内容会使用nextHandler完成后续调用
     *
     * @param request          任务和参与者信息
     * @param response         响应
     * @param dataHandlerChain 下一个Handler
     */
    void handle(TaskRelationRequest request, TaskRelationResponse response, TaskRelationHandlerChain dataHandlerChain);

    /**
     * 如果链路中出现错误，可以通过实现该接口捕获到错误
     *
     * @param request  rowModel
     * @param response 响应
     * @param ex       异常
     */
    default void onException(TaskRelationRequest request, TaskRelationResponse response, Exception ex) {

    }

    /**
     * 顺序，从小到大
     *
     * @return 权重
     */
    default int order() {
        return 0;
    }
}
