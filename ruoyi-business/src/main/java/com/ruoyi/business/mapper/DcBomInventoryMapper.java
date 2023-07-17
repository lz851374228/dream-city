package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.DcBomInventory;

/**
 * 物料库存Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public interface DcBomInventoryMapper 
{
    /**
     * 查询物料库存
     * 
     * @param inventoryId 物料库存主键
     * @return 物料库存
     */
    public DcBomInventory selectDcBomInventoryByInventoryId(Long inventoryId);

    /**
     * 查询物料库存列表
     * 
     * @param dcBomInventory 物料库存
     * @return 物料库存集合
     */
    public List<DcBomInventory> selectDcBomInventoryList(DcBomInventory dcBomInventory);

    /**
     * 新增物料库存
     * 
     * @param dcBomInventory 物料库存
     * @return 结果
     */
    public int insertDcBomInventory(DcBomInventory dcBomInventory);

    /**
     * 修改物料库存
     * 
     * @param dcBomInventory 物料库存
     * @return 结果
     */
    public int updateDcBomInventory(DcBomInventory dcBomInventory);

    /**
     * 删除物料库存
     * 
     * @param inventoryId 物料库存主键
     * @return 结果
     */
    public int deleteDcBomInventoryByInventoryId(Long inventoryId);

    /**
     * 批量删除物料库存
     * 
     * @param inventoryIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDcBomInventoryByInventoryIds(Long[] inventoryIds);
}
