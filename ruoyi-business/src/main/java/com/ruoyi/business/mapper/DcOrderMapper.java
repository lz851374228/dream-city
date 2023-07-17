package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.DcOrder;

/**
 * 订单Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public interface DcOrderMapper 
{
    /**
     * 查询订单
     * 
     * @param orderId 订单主键
     * @return 订单
     */
    public DcOrder selectDcOrderByOrderId(Long orderId);

    /**
     * 查询订单列表
     * 
     * @param dcOrder 订单
     * @return 订单集合
     */
    public List<DcOrder> selectDcOrderList(DcOrder dcOrder);

    /**
     * 新增订单
     * 
     * @param dcOrder 订单
     * @return 结果
     */
    public int insertDcOrder(DcOrder dcOrder);

    /**
     * 修改订单
     * 
     * @param dcOrder 订单
     * @return 结果
     */
    public int updateDcOrder(DcOrder dcOrder);

    /**
     * 删除订单
     * 
     * @param orderId 订单主键
     * @return 结果
     */
    public int deleteDcOrderByOrderId(Long orderId);

    /**
     * 批量删除订单
     * 
     * @param orderIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDcOrderByOrderIds(Long[] orderIds);
}
