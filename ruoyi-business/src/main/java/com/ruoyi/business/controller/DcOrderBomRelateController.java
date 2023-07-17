package com.ruoyi.business.controller;

import java.util.List;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.annotation.Log;
import com.ruoyi.common.core.controller.BaseController;
import com.ruoyi.common.core.domain.AjaxResult;
import com.ruoyi.common.enums.BusinessType;
import com.ruoyi.business.domain.DcOrderBomRelate;
import com.ruoyi.business.service.IDcOrderBomRelateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 订单物料关系Controller
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/business/orderBomRelate")
public class DcOrderBomRelateController extends BaseController
{
    @Autowired
    private IDcOrderBomRelateService dcOrderBomRelateService;

    /**
     * 查询订单物料关系列表
     */
    @PreAuthorize("@ss.hasPermi('business:orderBomRelate:list')")
    @GetMapping("/list")
    public TableDataInfo list(DcOrderBomRelate dcOrderBomRelate)
    {
        startPage();
        List<DcOrderBomRelate> list = dcOrderBomRelateService.selectDcOrderBomRelateList(dcOrderBomRelate);
        return getDataTable(list);
    }

    /**
     * 导出订单物料关系列表
     */
    @PreAuthorize("@ss.hasPermi('business:orderBomRelate:export')")
    @Log(title = "订单物料关系", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DcOrderBomRelate dcOrderBomRelate)
    {
        List<DcOrderBomRelate> list = dcOrderBomRelateService.selectDcOrderBomRelateList(dcOrderBomRelate);
        ExcelUtil<DcOrderBomRelate> util = new ExcelUtil<DcOrderBomRelate>(DcOrderBomRelate.class);
        util.exportExcel(response, list, "订单物料关系数据");
    }

    /**
     * 获取订单物料关系详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:orderBomRelate:query')")
    @GetMapping(value = "/{orderBomRelateId}")
    public AjaxResult getInfo(@PathVariable("orderBomRelateId") Long orderBomRelateId)
    {
        return success(dcOrderBomRelateService.selectDcOrderBomRelateByOrderBomRelateId(orderBomRelateId));
    }

    /**
     * 新增订单物料关系
     */
    @PreAuthorize("@ss.hasPermi('business:orderBomRelate:add')")
    @Log(title = "订单物料关系", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DcOrderBomRelate dcOrderBomRelate)
    {
        return toAjax(dcOrderBomRelateService.insertDcOrderBomRelate(dcOrderBomRelate));
    }

    /**
     * 修改订单物料关系
     */
    @PreAuthorize("@ss.hasPermi('business:orderBomRelate:edit')")
    @Log(title = "订单物料关系", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DcOrderBomRelate dcOrderBomRelate)
    {
        return toAjax(dcOrderBomRelateService.updateDcOrderBomRelate(dcOrderBomRelate));
    }

    /**
     * 删除订单物料关系
     */
    @PreAuthorize("@ss.hasPermi('business:orderBomRelate:remove')")
    @Log(title = "订单物料关系", businessType = BusinessType.DELETE)
	@DeleteMapping("/{orderBomRelateIds}")
    public AjaxResult remove(@PathVariable Long[] orderBomRelateIds)
    {
        return toAjax(dcOrderBomRelateService.deleteDcOrderBomRelateByOrderBomRelateIds(orderBomRelateIds));
    }
}
