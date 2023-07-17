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
import com.ruoyi.business.domain.DcBomInventory;
import com.ruoyi.business.service.IDcBomInventoryService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物料库存Controller
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/business/bomInventory")
public class DcBomInventoryController extends BaseController
{
    @Autowired
    private IDcBomInventoryService dcBomInventoryService;

    /**
     * 查询物料库存列表
     */
    @PreAuthorize("@ss.hasPermi('business:bomInventory:list')")
    @GetMapping("/list")
    public TableDataInfo list(DcBomInventory dcBomInventory)
    {
        startPage();
        List<DcBomInventory> list = dcBomInventoryService.selectDcBomInventoryList(dcBomInventory);
        return getDataTable(list);
    }

    /**
     * 导出物料库存列表
     */
    @PreAuthorize("@ss.hasPermi('business:bomInventory:export')")
    @Log(title = "物料库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DcBomInventory dcBomInventory)
    {
        List<DcBomInventory> list = dcBomInventoryService.selectDcBomInventoryList(dcBomInventory);
        ExcelUtil<DcBomInventory> util = new ExcelUtil<DcBomInventory>(DcBomInventory.class);
        util.exportExcel(response, list, "物料库存数据");
    }

    /**
     * 获取物料库存详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:bomInventory:query')")
    @GetMapping(value = "/{inventoryId}")
    public AjaxResult getInfo(@PathVariable("inventoryId") Long inventoryId)
    {
        return success(dcBomInventoryService.selectDcBomInventoryByInventoryId(inventoryId));
    }

    /**
     * 新增物料库存
     */
    @PreAuthorize("@ss.hasPermi('business:bomInventory:add')")
    @Log(title = "物料库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DcBomInventory dcBomInventory)
    {
        return toAjax(dcBomInventoryService.insertDcBomInventory(dcBomInventory));
    }

    /**
     * 修改物料库存
     */
    @PreAuthorize("@ss.hasPermi('business:bomInventory:edit')")
    @Log(title = "物料库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DcBomInventory dcBomInventory)
    {
        return toAjax(dcBomInventoryService.updateDcBomInventory(dcBomInventory));
    }

    /**
     * 删除物料库存
     */
    @PreAuthorize("@ss.hasPermi('business:bomInventory:remove')")
    @Log(title = "物料库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{inventoryIds}")
    public AjaxResult remove(@PathVariable Long[] inventoryIds)
    {
        return toAjax(dcBomInventoryService.deleteDcBomInventoryByInventoryIds(inventoryIds));
    }
}
