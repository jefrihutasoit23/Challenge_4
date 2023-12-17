package com.aplikasi.chapter4.binarfud.service;

import com.aplikasi.chapter4.binarfud.entity.Order;

import java.util.List;

public interface OrderService {
    Order createOrder(Order order);
    List<Order> getOrders();
}
