package com.TradeFinance.feign;

//import com.TradeFinance.dto.ApplicantDto;
import com.TradeFinance.dto.ApplicantDto;
import com.TradeFinance.dto.SecondaryBeneficiaryDto;
import com.TradeFinance.dto.AccountResponse;
//import com.TradeFinance.dto.ApplicantDto;
import com.TradeFinance.dto.BeneficiaryDto;
import com.TradeFinance.util.ApiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@FeignClient(name = "account-service", url = "http://localhost:8187", configuration = FeignConfiguration.class)
@Configuration
public interface AccountClientService {
    @GetMapping("api/account/account-details")
    ApiResponse<AccountResponse[]> getAccountDetailsByCifIdOrAccountNumberOrNationalId(
            @RequestParam(value = "cifId",required = false) String cifId,
            @RequestParam(value = "accountNumber",required = false) String accountNumber,
            @RequestParam(value = "nationalId",required = false) String nationalId);
      @PostMapping("/api/applicant/applicant-details")
     ResponseEntity<?> enterApplicantDetails(@RequestBody ApplicantDto applicantDto);

    @PostMapping(value = "/api/v1/beneficiary/beneficiary-details", consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<?> enterBeneficiaryDetails(@RequestBody BeneficiaryDto beneficiaryDto);

    @PostMapping("/api/v1/secondaryBeneficiary/secondaryBeneficiary-details")
    ResponseEntity<?> enterSecondaryBeneficiaryDetails(@RequestBody SecondaryBeneficiaryDto secondaryBeneficiaryDto);

    @GetMapping("/{cifId}")
    ResponseEntity<ApiResponse<List<ApplicantDto>>> getAccountDetailsByCifId(@PathVariable String cifId);

}
