package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.DcBomRelate;

/**
 * 物料关系定义Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public interface DcBomRelateMapper 
{
    /**
     * 查询物料关系定义
     * 
     * @param relateId 物料关系定义主键
     * @return 物料关系定义
     */
    public DcBomRelate selectDcBomRelateByRelateId(Long relateId);

    /**
     * 查询物料关系定义列表
     * 
     * @param dcBomRelate 物料关系定义
     * @return 物料关系定义集合
     */
    public List<DcBomRelate> selectDcBomRelateList(DcBomRelate dcBomRelate);

    /**
     * 新增物料关系定义
     * 
     * @param dcBomRelate 物料关系定义
     * @return 结果
     */
    public int insertDcBomRelate(DcBomRelate dcBomRelate);

    /**
     * 修改物料关系定义
     * 
     * @param dcBomRelate 物料关系定义
     * @return 结果
     */
    public int updateDcBomRelate(DcBomRelate dcBomRelate);

    /**
     * 删除物料关系定义
     * 
     * @param relateId 物料关系定义主键
     * @return 结果
     */
    public int deleteDcBomRelateByRelateId(Long relateId);

    /**
     * 批量删除物料关系定义
     * 
     * @param relateIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDcBomRelateByRelateIds(Long[] relateIds);
}
