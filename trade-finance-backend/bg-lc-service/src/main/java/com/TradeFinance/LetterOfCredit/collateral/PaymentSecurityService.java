package com.TradeFinance.LetterOfCredit.collateral;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PaymentSecurityService {
    @Autowired
    private PaymentRepository paymentRepository;
    public PaymentSecurity createPaymentSecurity(PaymentSecurity paymentSecurity) {
        return paymentRepository.save(paymentSecurity);

    }
}
