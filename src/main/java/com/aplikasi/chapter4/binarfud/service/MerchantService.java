package com.aplikasi.chapter4.binarfud.service;

import com.aplikasi.chapter4.binarfud.entity.Merchant;

import java.util.List;
import java.util.Map;

public interface MerchantService {
    Map addMerchant(Merchant merchant);
    Map updateMerchantStatus(Long merchantId, boolean isOpen);
    Map update(Merchant merchant);
    List<Merchant> getOpenMerchants();
}
