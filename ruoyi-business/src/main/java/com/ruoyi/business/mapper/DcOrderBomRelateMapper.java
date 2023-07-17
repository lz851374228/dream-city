package com.ruoyi.business.mapper;

import java.util.List;
import com.ruoyi.business.domain.DcOrderBomRelate;

/**
 * 订单物料关系Mapper接口
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
public interface DcOrderBomRelateMapper 
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
     * 删除订单物料关系
     * 
     * @param orderBomRelateId 订单物料关系主键
     * @return 结果
     */
    public int deleteDcOrderBomRelateByOrderBomRelateId(Long orderBomRelateId);

    /**
     * 批量删除订单物料关系
     * 
     * @param orderBomRelateIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteDcOrderBomRelateByOrderBomRelateIds(Long[] orderBomRelateIds);
}
