package com.dugu.java.design.demo.service.design.chain.common.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @Description 任务信息模型
 * @Author by cihun
 * @Date 2020/5/16 10:28 PM
 */
@Setter
@Getter
@ToString
public class TaskModel {

    /**
     * 任务Id
     */
    private Long taskId;

    /**
     * 任务名称
     */
    private String taskName;
    /**
     * 参与商家
     */
    private List<Long> merchantUserIdList;

    /**
     * 参与商品
     */
    private List<Long> offerIdList;
    /**
     * 参与者用户
     */
    private List<Long> userIdList;
}
