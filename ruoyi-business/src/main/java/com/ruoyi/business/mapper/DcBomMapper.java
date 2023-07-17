package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.DcBom;

/**
 * 物料定义Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public interface DcBomMapper 
{
    /**
     * 查询物料定义
     * 
     * @param bomId 物料定义主键
     * @return 物料定义
     */
    public DcBom selectDcBomByBomId(Long bomId);

    /**
     * 查询物料定义列表
     * 
     * @param dcBom 物料定义
     * @return 物料定义集合
     */
    public List<DcBom> selectDcBomList(DcBom dcBom);

    /**
     * 新增物料定义
     * 
     * @param dcBom 物料定义
     * @return 结果
     */
    public int insertDcBom(DcBom dcBom);

    /**
     * 修改物料定义
     * 
     * @param dcBom 物料定义
     * @return 结果
     */
    public int updateDcBom(DcBom dcBom);

    /**
     * 删除物料定义
     * 
     * @param bomId 物料定义主键
     * @return 结果
     */
    public int deleteDcBomByBomId(Long bomId);

    /**
     * 批量删除物料定义
     * 
     * @param bomIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDcBomByBomIds(Long[] bomIds);
}
