<template>
  <div class="app-container">
    <el-form :model="queryParams" ref="queryForm" size="small" :inline="true" v-show="showSearch" label-width="68px">
      <el-form-item label="关联物料定义ID" prop="bomRelateId">
        <el-input
          v-model="queryParams.bomRelateId"
          placeholder="请输入关联物料定义ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所需物料定义ID" prop="needBomId">
        <el-input
          v-model="queryParams.needBomId"
          placeholder="请输入所需物料定义ID"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所需物料定义名称" prop="needBomName">
        <el-input
          v-model="queryParams.needBomName"
          placeholder="请输入所需物料定义名称"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item label="所需物料数量" prop="needNumber">
        <el-input
          v-model="queryParams.needNumber"
          placeholder="请输入所需物料数量"
          clearable
          @keyup.enter.native="handleQuery"
        />
      </el-form-item>
      <el-form-item>
        <el-button type="primary" icon="el-icon-search" size="mini" @click="handleQuery">搜索</el-button>
        <el-button icon="el-icon-refresh" size="mini" @click="resetQuery">重置</el-button>
      </el-form-item>
    </el-form>

    <el-row :gutter="10" class="mb8">
      <el-col :span="1.5">
        <el-button
          type="primary"
          plain
          icon="el-icon-plus"
          size="mini"
          @click="handleAdd"
          v-hasPermi="['business:bomRelate:add']"
        >新增</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="success"
          plain
          icon="el-icon-edit"
          size="mini"
          :disabled="single"
          @click="handleUpdate"
          v-hasPermi="['business:bomRelate:edit']"
        >修改</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="danger"
          plain
          icon="el-icon-delete"
          size="mini"
          :disabled="multiple"
          @click="handleDelete"
          v-hasPermi="['business:bomRelate:remove']"
        >删除</el-button>
      </el-col>
      <el-col :span="1.5">
        <el-button
          type="warning"
          plain
          icon="el-icon-download"
          size="mini"
          @click="handleExport"
          v-hasPermi="['business:bomRelate:export']"
        >导出</el-button>
      </el-col>
      <right-toolbar :showSearch.sync="showSearch" @queryTable="getList"></right-toolbar>
    </el-row>

    <el-table v-loading="loading" :data="bomRelateList" @selection-change="handleSelectionChange">
      <el-table-column type="selection" width="55" align="center" />
      <el-table-column label="物料关系定义ID" align="center" prop="relateId" />
      <el-table-column label="关联物料定义ID" align="center" prop="bomRelateId" />
      <el-table-column label="所需物料定义ID" align="center" prop="needBomId" />
      <el-table-column label="所需物料定义名称" align="center" prop="needBomName" />
      <el-table-column label="所需物料数量" align="center" prop="needNumber" />
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
          <el-button
            size="mini"
            type="text"
            icon="el-icon-edit"
            @click="handleUpdate(scope.row)"
            v-hasPermi="['business:bomRelate:edit']"
          >修改</el-button>
          <el-button
            size="mini"
            type="text"
            icon="el-icon-delete"
            @click="handleDelete(scope.row)"
            v-hasPermi="['business:bomRelate:remove']"
          >删除</el-button>
        </template>
      </el-table-column>
    </el-table>
    
    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />

    <!-- 添加或修改物料关系定义对话框 -->
    <el-dialog :title="title" :visible.sync="open" width="500px" append-to-body>
      <el-form ref="form" :model="form" :rules="rules" label-width="80px">
        <el-form-item label="关联物料定义ID" prop="bomRelateId">
          <el-input v-model="form.bomRelateId" placeholder="请输入关联物料定义ID" />
        </el-form-item>
        <el-form-item label="所需物料定义ID" prop="needBomId">
          <el-input v-model="form.needBomId" placeholder="请输入所需物料定义ID" />
        </el-form-item>
        <el-form-item label="所需物料定义名称" prop="needBomName">
          <el-input v-model="form.needBomName" placeholder="请输入所需物料定义名称" />
        </el-form-item>
        <el-form-item label="所需物料数量" prop="needNumber">
          <el-input v-model="form.needNumber" placeholder="请输入所需物料数量" />
        </el-form-item>
      </el-form>
      <div slot="footer" class="dialog-footer">
        <el-button type="primary" @click="submitForm">确 定</el-button>
        <el-button @click="cancel">取 消</el-button>
      </div>
    </el-dialog>
  </div>
</template>

<script>
import { listBomRelate, getBomRelate, delBomRelate, addBomRelate, updateBomRelate } from "@/api/business/bomRelate";

export default {
  name: "BomRelate",
  data() {
    return {
      // 遮罩层
      loading: true,
      // 选中数组
      ids: [],
      // 非单个禁用
      single: true,
      // 非多个禁用
      multiple: true,
      // 显示搜索条件
      showSearch: true,
      // 总条数
      total: 0,
      // 物料关系定义表格数据
      bomRelateList: [],
      // 弹出层标题
      title: "",
      // 是否显示弹出层
      open: false,
      // 查询参数
      queryParams: {
        pageNum: 1,
        pageSize: 10,
        bomRelateId: null,
        needBomId: null,
        needBomName: null,
        needNumber: null,
      },
      // 表单参数
      form: {},
      // 表单校验
      rules: {
        bomRelateId: [
          { required: true, message: "关联物料定义ID不能为空", trigger: "blur" }
        ],
        needBomId: [
          { required: true, message: "所需物料定义ID不能为空", trigger: "blur" }
        ],
        needBomName: [
          { required: true, message: "所需物料定义名称不能为空", trigger: "blur" }
        ],
        needNumber: [
          { required: true, message: "所需物料数量不能为空", trigger: "blur" }
        ],
      }
    };
  },
  created() {
    this.getList();
  },
  methods: {
    /** 查询物料关系定义列表 */
    getList() {
      this.loading = true;
      listBomRelate(this.queryParams).then(response => {
        this.bomRelateList = response.rows;
        this.total = response.total;
        this.loading = false;
      });
    },
    // 取消按钮
    cancel() {
      this.open = false;
      this.reset();
    },
    // 表单重置
    reset() {
      this.form = {
        relateId: null,
        bomRelateId: null,
        needBomId: null,
        needBomName: null,
        needNumber: null,
        createBy: null,
        createTime: null,
        updateBy: null,
        updateTime: null
      };
      this.resetForm("form");
    },
    /** 搜索按钮操作 */
    handleQuery() {
      this.queryParams.pageNum = 1;
      this.getList();
    },
    /** 重置按钮操作 */
    resetQuery() {
      this.resetForm("queryForm");
      this.handleQuery();
    },
    // 多选框选中数据
    handleSelectionChange(selection) {
      this.ids = selection.map(item => item.relateId)
      this.single = selection.length!==1
      this.multiple = !selection.length
    },
    /** 新增按钮操作 */
    handleAdd() {
      this.reset();
      this.open = true;
      this.title = "添加物料关系定义";
    },
    /** 修改按钮操作 */
    handleUpdate(row) {
      this.reset();
      const relateId = row.relateId || this.ids
      getBomRelate(relateId).then(response => {
        this.form = response.data;
        this.open = true;
        this.title = "修改物料关系定义";
      });
    },
    /** 提交按钮 */
    submitForm() {
      this.$refs["form"].validate(valid => {
        if (valid) {
          if (this.form.relateId != null) {
            updateBomRelate(this.form).then(response => {
              this.$modal.msgSuccess("修改成功");
              this.open = false;
              this.getList();
            });
          } else {
            addBomRelate(this.form).then(response => {
              this.$modal.msgSuccess("新增成功");
              this.open = false;
              this.getList();
            });
          }
        }
      });
    },
    /** 删除按钮操作 */
    handleDelete(row) {
      const relateIds = row.relateId || this.ids;
      this.$modal.confirm('是否确认删除物料关系定义编号为"' + relateIds + '"的数据项？').then(function() {
        return delBomRelate(relateIds);
      }).then(() => {
        this.getList();
        this.$modal.msgSuccess("删除成功");
      }).catch(() => {});
    },
    /** 导出按钮操作 */
    handleExport() {
      this.download('business/bomRelate/export', {
        ...this.queryParams
      }, `bomRelate_${new Date().getTime()}.xlsx`)
    }
  }
};
</script>
