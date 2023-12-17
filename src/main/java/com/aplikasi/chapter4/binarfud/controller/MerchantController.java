package com.aplikasi.chapter4.binarfud.controller;

import com.aplikasi.chapter4.binarfud.entity.Merchant;
import com.aplikasi.chapter4.binarfud.repository.MerchantRepository;
import com.aplikasi.chapter4.binarfud.service.MerchantService;
import com.aplikasi.chapter4.binarfud.utils.SimpleStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.persistence.criteria.Predicate;

import java.util.*;

@RestController
@RequestMapping("/merchants")
public class MerchantController {

    @Autowired
    private MerchantService merchantService;
    SimpleStringUtils simpleStringUtils = new SimpleStringUtils();

    @Autowired
    public MerchantRepository merchantRepository;

    @PostMapping(value ={"/add","/add/"})
    public ResponseEntity<Map> addMerchant(@RequestBody Merchant merchant) {
        return new ResponseEntity<Map>(merchantService.addMerchant(merchant), HttpStatus.OK);
    }

    @PutMapping(value ={"/updateStatus", "/updateStatus/"})
    public ResponseEntity<Map> updateMerchantStatus(@RequestParam Long id, @RequestParam boolean isOpen) {
        return new ResponseEntity<Map>(merchantService.updateMerchantStatus(id, isOpen), HttpStatus.OK);
    }

    @PutMapping(value={"/update", "/update/"})
    public ResponseEntity<Map> update(@RequestBody Merchant request) {
        return new ResponseEntity<Map>(merchantService.update(request), HttpStatus.OK);
    }

    @GetMapping("/openMerchants")
    public List<Merchant> getOpenMerchants() {
        return merchantService.getOpenMerchants();
    }

    @GetMapping(value = {"/listMerchants", "/listMerchants/"})
    public ResponseEntity<Map> list(
            @RequestParam() Integer page,
            @RequestParam(required = true) Integer size,
            @RequestParam(required = false) String merchant_name,
            @RequestParam(required = false) String merchant_location,
            @RequestParam(required = false) String orderby,
            @RequestParam(required = false) String ordertype) {

        Pageable show_data = simpleStringUtils.getShort(orderby, ordertype, page, size);

        Specification<Merchant> spec =
                ((root, query, criteriaBuilder) -> {
                    List<Predicate> predicates = new ArrayList<>();
                    if (merchant_name != null && !merchant_name.isEmpty()) {
                        predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.get("merchant_name")), "%" + merchant_name.toLowerCase() + "%"));
                    }
                    if (merchant_location != null && !merchant_location.isEmpty()) {
                        predicates.add(criteriaBuilder.equal(root.get("merchant_location"), merchant_location));
                    }
                    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
                });
        Page<Merchant> list = merchantRepository.findAll(spec, show_data);

        Map map = new HashMap();
        map.put("data",list);
        return new ResponseEntity<Map>(map, new HttpHeaders(), HttpStatus.OK);
    }
}
