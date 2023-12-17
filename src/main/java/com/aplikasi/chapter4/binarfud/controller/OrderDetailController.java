package com.aplikasi.chapter4.binarfud.controller;

import com.aplikasi.chapter4.binarfud.entity.OrderDetail;
import com.aplikasi.chapter4.binarfud.service.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orderDetails")
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @PostMapping("/add")
    public OrderDetail addOrderDetail(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.addOrderDetail(orderDetail);
    }

    @PutMapping("/update")
    public OrderDetail updateOrderDetail(@RequestBody OrderDetail orderDetail) {
        return orderDetailService.updateOrderDetail(orderDetail);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteOrderDetail(@PathVariable Long id) {
        orderDetailService.deleteOrderDetail(id);
    }

    // Anda dapat menambahkan metode tambahan jika diperlukan
}

