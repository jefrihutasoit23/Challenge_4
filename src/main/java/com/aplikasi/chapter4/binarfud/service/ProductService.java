package com.aplikasi.chapter4.binarfud.service;

import com.aplikasi.chapter4.binarfud.entity.Product;

import java.util.List;
import java.util.Map;

public interface ProductService {
    Map addProduct(Product product, Long merchantId);
    Map updateProduct(Product product, Long merchantId);
    Map deleteProduct(Long productId);
    List<Product> getAvailableProducts();
}
