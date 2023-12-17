package com.aplikasi.chapter4.binarfud.controller;

import com.aplikasi.chapter4.binarfud.entity.Order;
import com.aplikasi.chapter4.binarfud.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @PostMapping("/createOrder")
    public Order createOrder(@RequestBody Order order) {
        return orderService.createOrder(order);
    }

    @GetMapping("/getOrders")
    public List<Order> getOrders() {
        return orderService.getOrders();
    }
}

