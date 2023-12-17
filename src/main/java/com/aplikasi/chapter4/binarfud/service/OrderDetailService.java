package com.aplikasi.chapter4.binarfud.service;

import com.aplikasi.chapter4.binarfud.entity.OrderDetail;

public interface OrderDetailService {
    OrderDetail addOrderDetail(OrderDetail orderDetail);
    OrderDetail updateOrderDetail(OrderDetail orderDetail);
    void deleteOrderDetail(Long orderDetailId);
}
