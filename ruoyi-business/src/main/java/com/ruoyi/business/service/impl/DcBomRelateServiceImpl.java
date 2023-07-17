package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.DcBomRelateMapper;
import com.ruoyi.business.domain.DcBomRelate;
import com.ruoyi.business.service.IDcBomRelateService;

/**
 * 物料关系定义Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Service
public class DcBomRelateServiceImpl implements IDcBomRelateService 
{
    @Autowired
    private DcBomRelateMapper dcBomRelateMapper;

    /**
     * 查询物料关系定义
     * 
     * @param relateId 物料关系定义主键
     * @return 物料关系定义
     */
    @Override
    public DcBomRelate selectDcBomRelateByRelateId(Long relateId)
    {
        return dcBomRelateMapper.selectDcBomRelateByRelateId(relateId);
    }

    /**
     * 查询物料关系定义列表
     * 
     * @param dcBomRelate 物料关系定义
     * @return 物料关系定义
     */
    @Override
    public List<DcBomRelate> selectDcBomRelateList(DcBomRelate dcBomRelate)
    {
        return dcBomRelateMapper.selectDcBomRelateList(dcBomRelate);
    }

    /**
     * 新增物料关系定义
     * 
     * @param dcBomRelate 物料关系定义
     * @return 结果
     */
    @Override
    public int insertDcBomRelate(DcBomRelate dcBomRelate)
    {
        dcBomRelate.setCreateTime(DateUtils.getNowDate());
        return dcBomRelateMapper.insertDcBomRelate(dcBomRelate);
    }

    /**
     * 修改物料关系定义
     * 
     * @param dcBomRelate 物料关系定义
     * @return 结果
     */
    @Override
    public int updateDcBomRelate(DcBomRelate dcBomRelate)
    {
        dcBomRelate.setUpdateTime(DateUtils.getNowDate());
        return dcBomRelateMapper.updateDcBomRelate(dcBomRelate);
    }

    /**
     * 批量删除物料关系定义
     * 
     * @param relateIds 需要删除的物料关系定义主键
     * @return 结果
     */
    @Override
    public int deleteDcBomRelateByRelateIds(Long[] relateIds)
    {
        return dcBomRelateMapper.deleteDcBomRelateByRelateIds(relateIds);
    }

    /**
     * 删除物料关系定义信息
     * 
     * @param relateId 物料关系定义主键
     * @return 结果
     */
    @Override
    public int deleteDcBomRelateByRelateId(Long relateId)
    {
        return dcBomRelateMapper.deleteDcBomRelateByRelateId(relateId);
    }
}
