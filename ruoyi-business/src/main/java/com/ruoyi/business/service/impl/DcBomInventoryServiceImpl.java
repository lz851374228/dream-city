package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.DcBomInventoryMapper;
import com.ruoyi.business.domain.DcBomInventory;
import com.ruoyi.business.service.IDcBomInventoryService;

/**
 * 物料库存Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Service
public class DcBomInventoryServiceImpl implements IDcBomInventoryService 
{
    @Autowired
    private DcBomInventoryMapper dcBomInventoryMapper;

    /**
     * 查询物料库存
     * 
     * @param inventoryId 物料库存主键
     * @return 物料库存
     */
    @Override
    public DcBomInventory selectDcBomInventoryByInventoryId(Long inventoryId)
    {
        return dcBomInventoryMapper.selectDcBomInventoryByInventoryId(inventoryId);
    }

    /**
     * 查询物料库存列表
     * 
     * @param dcBomInventory 物料库存
     * @return 物料库存
     */
    @Override
    public List<DcBomInventory> selectDcBomInventoryList(DcBomInventory dcBomInventory)
    {
        return dcBomInventoryMapper.selectDcBomInventoryList(dcBomInventory);
    }

    /**
     * 新增物料库存
     * 
     * @param dcBomInventory 物料库存
     * @return 结果
     */
    @Override
    public int insertDcBomInventory(DcBomInventory dcBomInventory)
    {
        dcBomInventory.setCreateTime(DateUtils.getNowDate());
        return dcBomInventoryMapper.insertDcBomInventory(dcBomInventory);
    }

    /**
     * 修改物料库存
     * 
     * @param dcBomInventory 物料库存
     * @return 结果
     */
    @Override
    public int updateDcBomInventory(DcBomInventory dcBomInventory)
    {
        dcBomInventory.setUpdateTime(DateUtils.getNowDate());
        return dcBomInventoryMapper.updateDcBomInventory(dcBomInventory);
    }

    /**
     * 批量删除物料库存
     * 
     * @param inventoryIds 需要删除的物料库存主键
     * @return 结果
     */
    @Override
    public int deleteDcBomInventoryByInventoryIds(Long[] inventoryIds)
    {
        return dcBomInventoryMapper.deleteDcBomInventoryByInventoryIds(inventoryIds);
    }

    /**
     * 删除物料库存信息
     * 
     * @param inventoryId 物料库存主键
     * @return 结果
     */
    @Override
    public int deleteDcBomInventoryByInventoryId(Long inventoryId)
    {
        return dcBomInventoryMapper.deleteDcBomInventoryByInventoryId(inventoryId);
    }
}
