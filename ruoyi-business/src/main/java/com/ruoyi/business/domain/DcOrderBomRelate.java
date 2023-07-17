package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 订单物料关系对象 dc_order_bom_relate
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public class DcOrderBomRelate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 订单物料关系表ID */
    private Long orderBomRelateId;

    /** 订单id */
    @Excel(name = "订单id")
    private Long orderId;

    /** 物料id */
    @Excel(name = "物料id")
    private Long bomId;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String bomName;

    /** 物料数量 */
    @Excel(name = "物料数量")
    private Integer bomNumber;

    public void setOrderBomRelateId(Long orderBomRelateId) 
    {
        this.orderBomRelateId = orderBomRelateId;
    }

    public Long getOrderBomRelateId() 
    {
        return orderBomRelateId;
    }
    public void setOrderId(Long orderId) 
    {
        this.orderId = orderId;
    }

    public Long getOrderId() 
    {
        return orderId;
    }
    public void setBomId(Long bomId) 
    {
        this.bomId = bomId;
    }

    public Long getBomId() 
    {
        return bomId;
    }
    public void setBomName(String bomName) 
    {
        this.bomName = bomName;
    }

    public String getBomName() 
    {
        return bomName;
    }
    public void setBomNumber(Integer bomNumber) 
    {
        this.bomNumber = bomNumber;
    }

    public Integer getBomNumber() 
    {
        return bomNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("orderBomRelateId", getOrderBomRelateId())
            .append("orderId", getOrderId())
            .append("bomId", getBomId())
            .append("bomName", getBomName())
            .append("bomNumber", getBomNumber())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
