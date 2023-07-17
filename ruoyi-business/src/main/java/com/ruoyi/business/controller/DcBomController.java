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
import com.ruoyi.business.domain.DcBom;
import com.ruoyi.business.service.IDcBomService;
import com.ruoyi.common.utils.poi.ExcelUtil;
import com.ruoyi.common.core.page.TableDataInfo;

/**
 * 物料定义Controller
 * 
 * @author ruoyi
 * @date 2023-07-16
 */
@RestController
@RequestMapping("/business/bom")
public class DcBomController extends BaseController
{
    @Autowired
    private IDcBomService dcBomService;

    /**
     * 查询物料定义列表
     */
    @PreAuthorize("@ss.hasPermi('business:bom:list')")
    @GetMapping("/list")
    public TableDataInfo list(DcBom dcBom)
    {
        startPage();
        List<DcBom> list = dcBomService.selectDcBomList(dcBom);
        return getDataTable(list);
    }

    /**
     * 导出物料定义列表
     */
    @PreAuthorize("@ss.hasPermi('business:bom:export')")
    @Log(title = "物料定义", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, DcBom dcBom)
    {
        List<DcBom> list = dcBomService.selectDcBomList(dcBom);
        ExcelUtil<DcBom> util = new ExcelUtil<DcBom>(DcBom.class);
        util.exportExcel(response, list, "物料定义数据");
    }

    /**
     * 获取物料定义详细信息
     */
    @PreAuthorize("@ss.hasPermi('business:bom:query')")
    @GetMapping(value = "/{bomId}")
    public AjaxResult getInfo(@PathVariable("bomId") Long bomId)
    {
        return success(dcBomService.selectDcBomByBomId(bomId));
    }

    /**
     * 新增物料定义
     */
    @PreAuthorize("@ss.hasPermi('business:bom:add')")
    @Log(title = "物料定义", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody DcBom dcBom)
    {
        return toAjax(dcBomService.insertDcBom(dcBom));
    }

    /**
     * 修改物料定义
     */
    @PreAuthorize("@ss.hasPermi('business:bom:edit')")
    @Log(title = "物料定义", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody DcBom dcBom)
    {
        return toAjax(dcBomService.updateDcBom(dcBom));
    }

    /**
     * 删除物料定义
     */
    @PreAuthorize("@ss.hasPermi('business:bom:remove')")
    @Log(title = "物料定义", businessType = BusinessType.DELETE)
	@DeleteMapping("/{bomIds}")
    public AjaxResult remove(@PathVariable Long[] bomIds)
    {
        return toAjax(dcBomService.deleteDcBomByBomIds(bomIds));
    }
}
