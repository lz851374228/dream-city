package com.ruoyi.business.service;

import java.util.List;
import com.ruoyi.business.domain.DcOrderBomRelate;

/**
 * 订单物料关系Service接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public interface IDcOrderBomRelateService 
{
    /**
     * 查询订单物料关系
     * 
     * @param orderBomRelateId 订单物料关系主键
     * @return 订单物料关系
     */
    public DcOrderBomRelate selectDcOrderBomRelateByOrderBomRelateId(Long orderBomRelateId);

    /**
     * 查询订单物料关系列表
     * 
     * @param dcOrderBomRelate 订单物料关系
     * @return 订单物料关系集合
     */
    public List<DcOrderBomRelate> selectDcOrderBomRelateList(DcOrderBomRelate dcOrderBomRelate);

    /**
     * 新增订单物料关系
     * 
     * @param dcOrderBomRelate 订单物料关系
     * @return 结果
     */
    public int insertDcOrderBomRelate(DcOrderBomRelate dcOrderBomRelate);

    /**
     * 修改订单物料关系
     * 
     * @param dcOrderBomRelate 订单物料关系
     * @return 结果
     */
    public int updateDcOrderBomRelate(DcOrderBomRelate dcOrderBomRelate);

    /**
     * 批量删除订单物料关系
     * 
     * @param orderBomRelateIds 需要删除的订单物料关系主键集合
     * @return 结果
     */
    public int deleteDcOrderBomRelateByOrderBomRelateIds(Long[] orderBomRelateIds);

    /**
     * 删除订单物料关系信息
     * 
     * @param orderBomRelateId 订单物料关系主键
     * @return 结果
     */
    public int deleteDcOrderBomRelateByOrderBomRelateId(Long orderBomRelateId);
}
