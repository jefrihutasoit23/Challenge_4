package com.aplikasi.chapter4.binarfud.service.impl;

import com.aplikasi.chapter4.binarfud.service.OrderDetailService;
import com.aplikasi.chapter4.binarfud.entity.OrderDetail;
import com.aplikasi.chapter4.binarfud.repository.OrderDetailRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetail addOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void deleteOrderDetail(Long orderDetailId) {
        orderDetailRepository.deleteById(orderDetailId);
    }
}
