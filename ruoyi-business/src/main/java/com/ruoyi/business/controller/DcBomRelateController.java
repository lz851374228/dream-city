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
import com.ruoyi.business.domain.DcBomRelate;
import com.ruoyi.business.service.IDcBomRelateService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物料关系定义Controller
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/business/bomRelate")
public class DcBomRelateController extends BaseController
{
    @Autowired
    private IDcBomRelateService dcBomRelateService;

    /**
     * 查询物料关系定义列表
     */
    @PreAuthorize("@ss.hasPermi('business:bomRelate:list')")
    @GetMapping("/list")
    public TableDataInfo list(DcBomRelate dcBomRelate)
    {
        startPage();
        List<DcBomRelate> list = dcBomRelateService.selectDcBomRelateList(dcBomRelate);
        return getDataTable(list);
    }

    /**
     * 导出物料关系定义列表
     */
    @PreAuthorize("@ss.hasPermi('business:bomRelate:export')")
    @Log(title = "物料关系定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DcBomRelate dcBomRelate)
    {
        List<DcBomRelate> list = dcBomRelateService.selectDcBomRelateList(dcBomRelate);
        ExcelUtil<DcBomRelate> util = new ExcelUtil<DcBomRelate>(DcBomRelate.class);
        util.exportExcel(response, list, "物料关系定义数据");
    }

    /**
     * 获取物料关系定义详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:bomRelate:query')")
    @GetMapping(value = "/{relateId}")
    public AjaxResult getInfo(@PathVariable("relateId") Long relateId)
    {
        return success(dcBomRelateService.selectDcBomRelateByRelateId(relateId));
    }

    /**
     * 新增物料关系定义
     */
    @PreAuthorize("@ss.hasPermi('business:bomRelate:add')")
    @Log(title = "物料关系定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DcBomRelate dcBomRelate)
    {
        return toAjax(dcBomRelateService.insertDcBomRelate(dcBomRelate));
    }

    /**
     * 修改物料关系定义
     */
    @PreAuthorize("@ss.hasPermi('business:bomRelate:edit')")
    @Log(title = "物料关系定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DcBomRelate dcBomRelate)
    {
        return toAjax(dcBomRelateService.updateDcBomRelate(dcBomRelate));
    }

    /**
     * 删除物料关系定义
     */
    @PreAuthorize("@ss.hasPermi('business:bomRelate:remove')")
    @Log(title = "物料关系定义", businessType = BusinessType.DELETE)
	@DeleteMapping("/{relateIds}")
    public AjaxResult remove(@PathVariable Long[] relateIds)
    {
        return toAjax(dcBomRelateService.deleteDcBomRelateByRelateIds(relateIds));
    }
}
