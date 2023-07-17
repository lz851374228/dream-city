package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.DcOrderBomRelateMapper;
import com.ruoyi.business.domain.DcOrderBomRelate;
import com.ruoyi.business.service.IDcOrderBomRelateService;

/**
 * 订单物料关系Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Service
public class DcOrderBomRelateServiceImpl implements IDcOrderBomRelateService 
{
    @Autowired
    private DcOrderBomRelateMapper dcOrderBomRelateMapper;

    /**
     * 查询订单物料关系
     * 
     * @param orderBomRelateId 订单物料关系主键
     * @return 订单物料关系
     */
    @Override
    public DcOrderBomRelate selectDcOrderBomRelateByOrderBomRelateId(Long orderBomRelateId)
    {
        return dcOrderBomRelateMapper.selectDcOrderBomRelateByOrderBomRelateId(orderBomRelateId);
    }

    /**
     * 查询订单物料关系列表
     * 
     * @param dcOrderBomRelate 订单物料关系
     * @return 订单物料关系
     */
    @Override
    public List<DcOrderBomRelate> selectDcOrderBomRelateList(DcOrderBomRelate dcOrderBomRelate)
    {
        return dcOrderBomRelateMapper.selectDcOrderBomRelateList(dcOrderBomRelate);
    }

    /**
     * 新增订单物料关系
     * 
     * @param dcOrderBomRelate 订单物料关系
     * @return 结果
     */
    @Override
    public int insertDcOrderBomRelate(DcOrderBomRelate dcOrderBomRelate)
    {
        dcOrderBomRelate.setCreateTime(DateUtils.getNowDate());
        return dcOrderBomRelateMapper.insertDcOrderBomRelate(dcOrderBomRelate);
    }

    /**
     * 修改订单物料关系
     * 
     * @param dcOrderBomRelate 订单物料关系
     * @return 结果
     */
    @Override
    public int updateDcOrderBomRelate(DcOrderBomRelate dcOrderBomRelate)
    {
        dcOrderBomRelate.setUpdateTime(DateUtils.getNowDate());
        return dcOrderBomRelateMapper.updateDcOrderBomRelate(dcOrderBomRelate);
    }

    /**
     * 批量删除订单物料关系
     * 
     * @param orderBomRelateIds 需要删除的订单物料关系主键
     * @return 结果
     */
    @Override
    public int deleteDcOrderBomRelateByOrderBomRelateIds(Long[] orderBomRelateIds)
    {
        return dcOrderBomRelateMapper.deleteDcOrderBomRelateByOrderBomRelateIds(orderBomRelateIds);
    }

    /**
     * 删除订单物料关系信息
     * 
     * @param orderBomRelateId 订单物料关系主键
     * @return 结果
     */
    @Override
    public int deleteDcOrderBomRelateByOrderBomRelateId(Long orderBomRelateId)
    {
        return dcOrderBomRelateMapper.deleteDcOrderBomRelateByOrderBomRelateId(orderBomRelateId);
    }
}
