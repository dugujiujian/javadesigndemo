package com.dugu.java.design.demo.service.design.strategy.spring.common.enums;

/**
 * @Description TODO
 * @Author by zhangliping
 * @Date 2020/5/17 12:12 AM
 */
public enum TravelTypeEnum {
    PLANE("飞机"),
    HIG_SPEED_RAILWAY("高铁"),
    STEAMSHIP("轮船"),
    CAR("汽车");

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private String desc;

    TravelTypeEnum(String desc) {
        this.desc = desc;
    }
}
