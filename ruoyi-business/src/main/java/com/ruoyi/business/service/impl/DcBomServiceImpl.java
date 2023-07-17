package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.DcBomMapper;
import com.ruoyi.business.domain.DcBom;
import com.ruoyi.business.service.IDcBomService;

/**
 * 物料定义Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Service
public class DcBomServiceImpl implements IDcBomService 
{
    @Autowired
    private DcBomMapper dcBomMapper;

    /**
     * 查询物料定义
     * 
     * @param bomId 物料定义主键
     * @return 物料定义
     */
    @Override
    public DcBom selectDcBomByBomId(Long bomId)
    {
        return dcBomMapper.selectDcBomByBomId(bomId);
    }

    /**
     * 查询物料定义列表
     * 
     * @param dcBom 物料定义
     * @return 物料定义
     */
    @Override
    public List<DcBom> selectDcBomList(DcBom dcBom)
    {
        return dcBomMapper.selectDcBomList(dcBom);
    }

    /**
     * 新增物料定义
     * 
     * @param dcBom 物料定义
     * @return 结果
     */
    @Override
    public int insertDcBom(DcBom dcBom)
    {
        dcBom.setCreateTime(DateUtils.getNowDate());
        return dcBomMapper.insertDcBom(dcBom);
    }

    /**
     * 修改物料定义
     * 
     * @param dcBom 物料定义
     * @return 结果
     */
    @Override
    public int updateDcBom(DcBom dcBom)
    {
        dcBom.setUpdateTime(DateUtils.getNowDate());
        return dcBomMapper.updateDcBom(dcBom);
    }

    /**
     * 批量删除物料定义
     * 
     * @param bomIds 需要删除的物料定义主键
     * @return 结果
     */
    @Override
    public int deleteDcBomByBomIds(Long[] bomIds)
    {
        return dcBomMapper.deleteDcBomByBomIds(bomIds);
    }

    /**
     * 删除物料定义信息
     * 
     * @param bomId 物料定义主键
     * @return 结果
     */
    @Override
    public int deleteDcBomByBomId(Long bomId)
    {
        return dcBomMapper.deleteDcBomByBomId(bomId);
    }
}
