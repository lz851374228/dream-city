package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单对象 dc_order
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public class DcOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单ID */
    private Long orderId;

    /** 订单名称 */
    @Excel(name = "订单名称")
    private String orderName;

    /** 订单金额 */
    @Excel(name = "订单金额")
    private Integer orderMoney;

    /** 订单经验 */
    @Excel(name = "订单经验")
    private Integer orderExperience;

    /** 订单状态（0进行中，1已完成） */
    @Excel(name = "订单状态", readConverterExp = "0=进行中，1已完成")
    private String orderStatus;

    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setOrderName(String orderName) 
    {
        this.orderName = orderName;
    }

    public String getOrderName() 
    {
        return orderName;
    }
    public void setOrderMoney(Integer orderMoney) 
    {
        this.orderMoney = orderMoney;
    }

    public Integer getOrderMoney() 
    {
        return orderMoney;
    }
    public void setOrderExperience(Integer orderExperience) 
    {
        this.orderExperience = orderExperience;
    }

    public Integer getOrderExperience() 
    {
        return orderExperience;
    }
    public void setOrderStatus(String orderStatus) 
    {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() 
    {
        return orderStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderId", getOrderId())
            .append("orderName", getOrderName())
            .append("orderMoney", getOrderMoney())
            .append("orderExperience", getOrderExperience())
            .append("orderStatus", getOrderStatus())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
