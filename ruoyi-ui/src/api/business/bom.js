import request from '@/utils/request'

// 查询物料定义列表
export function listBom(query) {
  return request({
    url: '/business/bom/list',
    method: 'get',
    params: query
  })
}

// 查询物料定义详细
export function getBom(bomId) {
  return request({
    url: '/business/bom/' + bomId,
    method: 'get'
  })
}

// 新增物料定义
export function addBom(data) {
  return request({
    url: '/business/bom',
    method: 'post',
    data: data
  })
}

// 修改物料定义
export function updateBom(data) {
  return request({
    url: '/business/bom',
    method: 'put',
    data: data
  })
}

// 删除物料定义
export function delBom(bomId) {
  return request({
    url: '/business/bom/' + bomId,
    method: 'delete'
  })
}
