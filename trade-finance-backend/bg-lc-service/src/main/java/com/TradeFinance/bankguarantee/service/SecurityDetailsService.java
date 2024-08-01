package com.TradeFinance.bankguarantee.service;

import com.TradeFinance.bankguarantee.entity.SecurityDetails;
import com.TradeFinance.bankguarantee.repository.SecurityDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SecurityDetailsService {

    @Autowired
    private SecurityDetailsRepository securityDetailRepository;

    public List<SecurityDetails> getAllSecurityDetails() {
        return securityDetailRepository.findAll();
    }

    public Optional<SecurityDetails> getSecurityDetailById(Long collateralId) {
        return securityDetailRepository.findById(collateralId);
    }

    public SecurityDetails saveSecurityDetail(SecurityDetails securityDetail) {
        return securityDetailRepository.save(securityDetail);
    }

    public void deleteSecurityDetail(Long collateralId) {
        securityDetailRepository.deleteById(collateralId);
    }
}
