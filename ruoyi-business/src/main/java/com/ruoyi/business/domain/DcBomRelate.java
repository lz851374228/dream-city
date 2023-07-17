package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物料关系定义对象 dc_bom_relate
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public class DcBomRelate extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料关系定义ID */
    private Long relateId;

    /** 关联物料定义ID */
    @Excel(name = "关联物料定义ID")
    private Long bomRelateId;

    /** 所需物料定义ID */
    @Excel(name = "所需物料定义ID")
    private Long needBomId;

    /** 所需物料定义名称 */
    @Excel(name = "所需物料定义名称")
    private String needBomName;

    /** 所需物料数量 */
    @Excel(name = "所需物料数量")
    private Integer needNumber;

    public void setRelateId(Long relateId) 
    {
        this.relateId = relateId;
    }

    public Long getRelateId() 
    {
        return relateId;
    }
    public void setBomRelateId(Long bomRelateId) 
    {
        this.bomRelateId = bomRelateId;
    }

    public Long getBomRelateId() 
    {
        return bomRelateId;
    }
    public void setNeedBomId(Long needBomId) 
    {
        this.needBomId = needBomId;
    }

    public Long getNeedBomId() 
    {
        return needBomId;
    }
    public void setNeedBomName(String needBomName) 
    {
        this.needBomName = needBomName;
    }

    public String getNeedBomName() 
    {
        return needBomName;
    }
    public void setNeedNumber(Integer needNumber) 
    {
        this.needNumber = needNumber;
    }

    public Integer getNeedNumber() 
    {
        return needNumber;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("relateId", getRelateId())
            .append("bomRelateId", getBomRelateId())
            .append("needBomId", getNeedBomId())
            .append("needBomName", getNeedBomName())
            .append("needNumber", getNeedNumber())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
