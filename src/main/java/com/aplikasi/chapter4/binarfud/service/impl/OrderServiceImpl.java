package com.aplikasi.chapter4.binarfud.service.impl;

import com.aplikasi.chapter4.binarfud.entity.Order;
import com.aplikasi.chapter4.binarfud.repository.OrderRepository;
import com.aplikasi.chapter4.binarfud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderRepository orderRepository;

    @Override
    public Order createOrder(Order order) {
        return orderRepository.save(order);
    }

    @Override
    public List<Order> getOrders() {
        return orderRepository.findAll();
    }
}
