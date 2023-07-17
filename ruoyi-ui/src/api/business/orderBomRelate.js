import request from '@/utils/request'

// 查询订单物料关系列表
export function listOrderBomRelate(query) {
  return request({
    url: '/business/orderBomRelate/list',
    method: 'get',
    params: query
  })
}

// 查询订单物料关系详细
export function getOrderBomRelate(orderBomRelateId) {
  return request({
    url: '/business/orderBomRelate/' + orderBomRelateId,
    method: 'get'
  })
}

// 新增订单物料关系
export function addOrderBomRelate(data) {
  return request({
    url: '/business/orderBomRelate',
    method: 'post',
    data: data
  })
}

// 修改订单物料关系
export function updateOrderBomRelate(data) {
  return request({
    url: '/business/orderBomRelate',
    method: 'put',
    data: data
  })
}

// 删除订单物料关系
export function delOrderBomRelate(orderBomRelateId) {
  return request({
    url: '/business/orderBomRelate/' + orderBomRelateId,
    method: 'delete'
  })
}
