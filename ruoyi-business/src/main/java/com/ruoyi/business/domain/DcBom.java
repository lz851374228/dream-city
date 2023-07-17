package com.ruoyi.business.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.annotation.Excel;
import com.ruoyi.common.core.domain.BaseEntity;

/**
 * 物料定义对象 dc_bom
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public class DcBom extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物料定义ID */
    private Long bomId;

    /** 物料定义名称 */
    @Excel(name = "物料定义名称")
    private String bomName;

    /** 生产周期(分) */
    @Excel(name = "生产周期(分)")
    private Integer bomTime;

    /** 是否需要子物料（0不需要，1需要） */
    @Excel(name = "是否需要子物料", readConverterExp = "0=不需要，1需要")
    private String isNeedBom;

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
    public void setBomTime(Integer bomTime) 
    {
        this.bomTime = bomTime;
    }

    public Integer getBomTime() 
    {
        return bomTime;
    }
    public void setIsNeedBom(String isNeedBom) 
    {
        this.isNeedBom = isNeedBom;
    }

    public String getIsNeedBom() 
    {
        return isNeedBom;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("bomId", getBomId())
            .append("bomName", getBomName())
            .append("bomTime", getBomTime())
            .append("isNeedBom", getIsNeedBom())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
