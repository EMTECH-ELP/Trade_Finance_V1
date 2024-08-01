//package com.TradeFinance.LetterOfCredit.collateral;
//
//import lombok.RequiredArgsConstructor;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.annotation.*;
//
//import java.util.List;
//import java.util.Optional;@RestController
//    @RequestMapping("/api/payment-security")
//    @RequiredArgsConstructor
//    public class PaymentSecurityController {
//
//        private final PaymentSecurityService paymentSecurityService;
//
//        @PostMapping("/create")
//        public String createPaymentSecurity(@RequestBody PaymentSecurityDto paymentSecurityDto) {
//            paymentSecurityService.createPaymentSecurity(paymentSecurityDto);
//            return "Created";
//        }
//
////
////
////        @GetMapping("/view All")
////        public ResponseEntity<List<PaymentSecurity>> getAllSecurityDetails() {
////            List<PaymentSecurity> paymentSecurities = com.TradeFinance.LetterOfCredit.collateral.PaymentSecurityController.this.paymentSecurityService.findAll();
////            return ResponseEntity.ok(paymentSecurities);
////        }
////
////        @GetMapping("/{paymentSecurityId}")
////        public ResponseEntity<PaymentSecurity> getSecurityDetailById(@PathVariable Long paymentSecurityId) {
////            Optional<PaymentSecurity> paymentSecurity = com.TradeFinance.LetterOfCredit.collateral.PaymentSecurityController.this.paymentSecurityService.findById(paymentSecurityId);
////            if (paymentSecurity.isPresent()) {
////                return ResponseEntity.ok(paymentSecurity.get());
////            } else {
////                return ResponseEntity.notFound().build();
////            }
////        }
//
//    }
//
//
//
