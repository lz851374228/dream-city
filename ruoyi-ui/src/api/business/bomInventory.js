import request from '@/utils/request'

// 查询物料库存列表
export function listBomInventory(query) {
  return request({
    url: '/business/bomInventory/list',
    method: 'get',
    params: query
  })
}

// 查询物料库存详细
export function getBomInventory(inventoryId) {
  return request({
    url: '/business/bomInventory/' + inventoryId,
    method: 'get'
  })
}

// 新增物料库存
export function addBomInventory(data) {
  return request({
    url: '/business/bomInventory',
    method: 'post',
    data: data
  })
}

// 修改物料库存
export function updateBomInventory(data) {
  return request({
    url: '/business/bomInventory',
    method: 'put',
    data: data
  })
}

// 删除物料库存
export function delBomInventory(inventoryId) {
  return request({
    url: '/business/bomInventory/' + inventoryId,
    method: 'delete'
  })
}
