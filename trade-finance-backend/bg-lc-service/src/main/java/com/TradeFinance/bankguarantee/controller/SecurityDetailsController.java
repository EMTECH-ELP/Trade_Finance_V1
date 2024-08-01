package com.TradeFinance.bankguarantee.controller;

import com.TradeFinance.bankguarantee.entity.SecurityDetails;
import com.TradeFinance.bankguarantee.service.SecurityDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/security-details")
public class SecurityDetailsController {

    @Autowired
    private SecurityDetailsService securityDetailService;

    @GetMapping
    public ResponseEntity<List<SecurityDetails>> getAllSecurityDetails() {
        List<SecurityDetails> securityDetails = securityDetailService.getAllSecurityDetails();
        return new ResponseEntity<>(securityDetails, HttpStatus.OK);
    }

    @GetMapping("/{collateralId}")
    public ResponseEntity<SecurityDetails> getSecurityDetailById(@PathVariable Long collateralId) {
        Optional<SecurityDetails> securityDetail = securityDetailService.getSecurityDetailById(collateralId);
        return securityDetail.map(value -> new ResponseEntity<>(value, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping
    public ResponseEntity<SecurityDetails> createSecurityDetail(@RequestBody SecurityDetails securityDetail) {
        SecurityDetails savedSecurityDetail = securityDetailService.saveSecurityDetail(securityDetail);
        return new ResponseEntity<>(savedSecurityDetail, HttpStatus.CREATED);
    }

    @DeleteMapping("/{collateralId}")
    public ResponseEntity<Void> deleteSecurityDetail(@PathVariable Long collateralId) {
        securityDetailService.deleteSecurityDetail(collateralId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
