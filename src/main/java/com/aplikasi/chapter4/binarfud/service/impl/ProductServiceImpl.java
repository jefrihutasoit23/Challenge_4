package com.aplikasi.chapter4.binarfud.service.impl;

import com.aplikasi.chapter4.binarfud.entity.Merchant;
import com.aplikasi.chapter4.binarfud.entity.Product;
import com.aplikasi.chapter4.binarfud.repository.MerchantRepository;
import com.aplikasi.chapter4.binarfud.repository.ProductRepository;
import com.aplikasi.chapter4.binarfud.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static java.time.LocalTime.now;

@Service
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private MerchantRepository merchantRepository;
    @Override
    public Map addProduct(Product product, Long merchantId) {
        Map map = new HashMap();
        Merchant merchant = merchantRepository.findById(merchantId).orElse(null);
        if (product != null) {
            product.setMerchant(merchant);
            Product doSave = productRepository.save(product);
            map.put("data",doSave);
            map.put("message","Success");
            map.put("code",200);
            return map;
        } else {
            map.put("message","data not found");
            return map;
        }
    }
    @Override
    public Map updateProduct(Product product, Long merchantId) {
        Map map = new HashMap();
        Product chekData = productRepository.getById(product.getId());
        Merchant merchant = merchantRepository.findById(merchantId).orElse(null);
        if(chekData == null){
            map.put("message","data not found");
            return map;
        }
        chekData.setProduct_name(product.getProduct_name());
        chekData.setPrice(product.getPrice());
        chekData.setMerchant(product.getMerchant());
        chekData.setUpdated_date(new Date());
        chekData.setMerchant(merchant);

        Product doUpdate = productRepository.save(chekData);
        map.put("data",doUpdate);
        map.put("message","Success");
        map.put("code",200);
        return map;
    }
    @Override
    public Map deleteProduct(Long productId) {
        Map map = new HashMap();
        Optional<Product> productOptional = productRepository.findById(productId);
        if (productOptional.isPresent()) {
            Product product = productOptional.get();
            product.setDeleted_date(new Date());
            Product doUpdate = productRepository.save(product);
            map.put("data",doUpdate);
            map.put("message","Delete Success");
            map.put("code",200);
            return map;
        }
        map.put("message","data not found");
        return map;
    }
    @Override
    public List<Product> getAvailableProducts() {
        return productRepository.findAll();
    }
}
