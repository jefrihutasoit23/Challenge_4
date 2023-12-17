package com.aplikasi.chapter4.binarfud.controller;

import com.aplikasi.chapter4.binarfud.entity.Merchant;
import com.aplikasi.chapter4.binarfud.entity.Product;
import com.aplikasi.chapter4.binarfud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping(value = {"/add","/add/"})
    public ResponseEntity<Map> addProduct(@RequestBody Product product, @RequestParam("merchantId") Long merchantId){
        return new ResponseEntity<Map>(productService.addProduct(product, merchantId), HttpStatus.OK);
    }

    @PutMapping(value = {"/update","/update/"})
    public ResponseEntity<Map> updateProduct(@RequestBody Product product, @RequestParam("merchantId") Long merchantId) {
        return new ResponseEntity<Map>(productService.updateProduct(product, merchantId), HttpStatus.OK);
    }

    @DeleteMapping(value = {"/delete/{id}","/delete/{id}/"})
    public ResponseEntity<Map> deleteProduct(@PathVariable Long id) {
        return new ResponseEntity<Map>(productService.deleteProduct(id), HttpStatus.OK);
    }

    @GetMapping(value = {"/availableProducts","/availableProducts/"})
    public List<Product> getAvailableProducts() {
        return productService.getAvailableProducts();
    }
}

