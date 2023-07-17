package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物料库存对象 dc_bom_inventory
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public class DcBomInventory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料库存ID */
    private Long inventoryId;

    /** 物料定义ID */
    @Excel(name = "物料定义ID")
    private Long bomId;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String bomName;

    /** 库存数量 */
    @Excel(name = "库存数量")
    private Integer inventoryNumber;

    /** 库存锁定数量 */
    @Excel(name = "库存锁定数量")
    private Integer inventoryNumberLock;

    public void setInventoryId(Long inventoryId) 
    {
        this.inventoryId = inventoryId;
    }

    public Long getInventoryId() 
    {
        return inventoryId;
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
    public void setInventoryNumber(Integer inventoryNumber) 
    {
        this.inventoryNumber = inventoryNumber;
    }

    public Integer getInventoryNumber() 
    {
        return inventoryNumber;
    }
    public void setInventoryNumberLock(Integer inventoryNumberLock) 
    {
        this.inventoryNumberLock = inventoryNumberLock;
    }

    public Integer getInventoryNumberLock() 
    {
        return inventoryNumberLock;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("inventoryId", getInventoryId())
            .append("bomId", getBomId())
            .append("bomName", getBomName())
            .append("inventoryNumber", getInventoryNumber())
            .append("inventoryNumberLock", getInventoryNumberLock())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
