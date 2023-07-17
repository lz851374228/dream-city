import request from '@/utils/request'

// 查询物料关系定义列表
export function listBomRelate(query) {
  return request({
    url: '/business/bomRelate/list',
    method: 'get',
    params: query
  })
}

// 查询物料关系定义详细
export function getBomRelate(relateId) {
  return request({
    url: '/business/bomRelate/' + relateId,
    method: 'get'
  })
}

// 新增物料关系定义
export function addBomRelate(data) {
  return request({
    url: '/business/bomRelate',
    method: 'post',
    data: data
  })
}

// 修改物料关系定义
export function updateBomRelate(data) {
  return request({
    url: '/business/bomRelate',
    method: 'put',
    data: data
  })
}

// 删除物料关系定义
export function delBomRelate(relateId) {
  return request({
    url: '/business/bomRelate/' + relateId,
    method: 'delete'
  })
}
