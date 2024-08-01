//package com.TradeFinance.feign;
//
//import com.TradeFinance.dto.ApplicantDto;
//import com.TradeFinance.dto.BeneficiaryDto;
//import com.TradeFinance.util.ApiResponse;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.http.ResponseEntity;
//import org.springframework.scheduling.annotation.Async;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.concurrent.CompletableFuture;
//
//@Service
//public class FeignService {
//    @Autowired
//    private AccountClientService accountClientService;
//
//    @Async
//    public CompletableFuture<ResponseEntity<ApiResponse<List<ApplicantDto>>>> getAccountDetailsByCifIdAsync(String cifId) {
//        return CompletableFuture.completedFuture(accountClientService.getAccountDetailsByCifId(cifId));
//    }
//
//    @Async
//    public CompletableFuture<BeneficiaryDto> getBeneficiaryDetailsAsync(BeneficiaryDto beneficiaryDto) {
//        return CompletableFuture.completedFuture(accountClientService.getBeneficiaryDetails(beneficiaryDto));
//    }
//}
