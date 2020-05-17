package com.dugu.java.design.demo.service.design.strategy.spring.common.enums;

/**
 * @Description 登记定义及折扣率
 * @Author by cihun
 * @Date 2020/5/17 12:28 PM
 */
public enum MemberGradeEnum {
    NORMAL("普通", 1),
    COPPER("铜", 0.9),
    SILVER("白银", 0.8),
    GOLD("黄金", 0.7),
    DIAMOND("钻石", 0.6);

    /**
     * 会员登记描述
     */
    private String desc;

    /**
     * 折扣率
     */
    private Double discount;

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public Double getDiscount() {
        return discount;
    }

    public void setDiscount(Double discount) {
        this.discount = discount;
    }


    MemberGradeEnum(String desc, double discount) {
        this.desc = desc;
        this.discount = discount;
    }
}
