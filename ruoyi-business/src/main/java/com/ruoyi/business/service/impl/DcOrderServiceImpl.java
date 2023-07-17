package com.ruoyi.business.service.impl;

import java.util.List;
import com.ruoyi.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.ruoyi.business.mapper.DcOrderMapper;
import com.ruoyi.business.domain.DcOrder;
import com.ruoyi.business.service.IDcOrderService;

/**
 * 订单Service业务层处理
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@Service
public class DcOrderServiceImpl implements IDcOrderService 
{
    @Autowired
    private DcOrderMapper dcOrderMapper;

    /**
     * 查询订单
     * 
     * @param orderId 订单主键
     * @return 订单
     */
    @Override
    public DcOrder selectDcOrderByOrderId(Long orderId)
    {
        return dcOrderMapper.selectDcOrderByOrderId(orderId);
    }

    /**
     * 查询订单列表
     * 
     * @param dcOrder 订单
     * @return 订单
     */
    @Override
    public List<DcOrder> selectDcOrderList(DcOrder dcOrder)
    {
        return dcOrderMapper.selectDcOrderList(dcOrder);
    }

    /**
     * 新增订单
     * 
     * @param dcOrder 订单
     * @return 结果
     */
    @Override
    public int insertDcOrder(DcOrder dcOrder)
    {
        dcOrder.setCreateTime(DateUtils.getNowDate());
        return dcOrderMapper.insertDcOrder(dcOrder);
    }

    /**
     * 修改订单
     * 
     * @param dcOrder 订单
     * @return 结果
     */
    @Override
    public int updateDcOrder(DcOrder dcOrder)
    {
        dcOrder.setUpdateTime(DateUtils.getNowDate());
        return dcOrderMapper.updateDcOrder(dcOrder);
    }

    /**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的订单主键
     * @return 结果
     */
    @Override
    public int deleteDcOrderByOrderIds(Long[] orderIds)
    {
        return dcOrderMapper.deleteDcOrderByOrderIds(orderIds);
    }

    /**
     * 删除订单信息
     * 
     * @param orderId 订单主键
     * @return 结果
     */
    @Override
    public int deleteDcOrderByOrderId(Long orderId)
    {
        return dcOrderMapper.deleteDcOrderByOrderId(orderId);
    }
}
