package com.aplikasi.chapter4.binarfud.service.impl;

import com.aplikasi.chapter4.binarfud.entity.Merchant;
import com.aplikasi.chapter4.binarfud.service.MerchantService;
import com.aplikasi.chapter4.binarfud.repository.MerchantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class MerchantServiceImpl implements MerchantService {

    @Autowired
    private MerchantRepository merchantRepository;

    @Override
    public Map addMerchant(Merchant merchant) {
        Map map = new HashMap();
        Merchant doSave = merchantRepository.save(merchant);
        map.put("data",doSave);
        map.put("message","Success");
        map.put("code",200);
        return map;
    }

    @Override
    public Map updateMerchantStatus(Long merchantId, boolean isOpen) {
        Map map = new HashMap();
        Optional<Merchant> merchantOptional = merchantRepository.findById(merchantId);
        if (merchantOptional.isPresent()) {
            Merchant merchant = merchantOptional.get();
            merchant.setOpen(isOpen);
            Merchant doUpdate = merchantRepository.save(merchant);
            map.put("data",doUpdate);
            map.put("message","Success");
            map.put("code",200);
            return map;
        }
        map.put("message","data not found");
        return map;
    }

    @Override
    public Map update(Merchant merchant) {
        Map map = new HashMap();
        Merchant chekData = merchantRepository.getById(merchant.getId());
        if(chekData == null){
            map.put("message","data not found");
            return map;
        }
        chekData.setMerchant_name(merchant.getMerchant_name());
        chekData.setMerchant_location(merchant.getMerchant_location());
        chekData.setOpen(merchant.getOpen());

        Merchant doUpdate = merchantRepository.save(chekData);
        map.put("data",doUpdate);
        map.put("message","Success");
        map.put("code",200);
        return map;
    }

    @Override
    public List<Merchant> getOpenMerchants() {
        return merchantRepository.findByOpenIsTrue();
    }
}
