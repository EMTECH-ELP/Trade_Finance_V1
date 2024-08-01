package com.TradeFinance.collectionservice.feign;

import com.TradeFinance.collectionservice.dto.AccountResponse;
//import com.TradeFinance.collectionservice.dto.ApplicantDto;
import com.TradeFinance.collectionservice.dto.BeneficiaryDto;
import com.TradeFinance.collectionservice.util.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "account-service", url = "http://localhost:8187")
@Configuration
public interface AccountInterface {
    @GetMapping("api/account/account-details")
    ApiResponse<AccountResponse[]> getAccountDetailsByCifIdOrAccountNumberOrNationalId(
            @RequestParam("cifId") String cifId,
            @RequestParam("accountNumber") String accountNumber,
            @RequestParam("nationalId") String nationalId);
  //  @PostMapping("/api/applicant/applicant-details")
   // ResponseEntity<?> enterApplicantDetails(@RequestBody ApplicantDto applicantDto);

    @PostMapping("/api/v1/beneficiary/beneficiary-details")
    ResponseEntity<?> enterBeneficiaryDetails(@RequestBody BeneficiaryDto beneficiaryDto);
}


