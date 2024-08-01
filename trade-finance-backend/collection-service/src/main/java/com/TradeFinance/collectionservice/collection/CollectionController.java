package com.TradeFinance.collectionservice.collection;

import com.TradeFinance.collectionservice.dto.AccountResponse;
import com.TradeFinance.collectionservice.dto.CollectionRequest;
import com.TradeFinance.collectionservice.feign.AccountInterface;
import com.TradeFinance.collectionservice.util.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/collection")
@RequiredArgsConstructor
public class CollectionController {


    private final CollectionService collectionService;


  /*  @GetMapping("/{cifId}")
    public AccountResponse getAccountDetailsByCifId(@PathVariable Long cifId) {
        return collectionService.getAccountDetailsByCifId(cifId);
       // ApiResponse<AccountResponse> response=collectionService.getAccountDetailsByCifId(cifId);
        //return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @PostMapping("/applicant")
    public ResponseEntity<ApiResponse<String>> enterApplicantDetails(@RequestBody ApplicantDto applicantDto) {
        ApiResponse<String> response = collectionService.enterApplicantDetails(applicantDto);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }*/

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<String>>createCollection(@RequestBody CollectionRequest collectionRequest) {
        ApiResponse<String> response = collectionService.createCollection(collectionRequest);
        return ResponseEntity.ok(new ApiResponse<>("Collection created successfully", null, HttpStatus.CREATED.value()));
    }

    @PostMapping("/{collectionId}/copy")
    public  ResponseEntity<ApiResponse<String>> createCollectionCopy(@PathVariable Long collectionId) {
        ApiResponse<String> response = collectionService.createCopy(collectionId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @PutMapping("/{collectionId}")
    public ResponseEntity<ApiResponse<Collection>>  modifyCollection(@PathVariable Long collectionId, @RequestBody CollectionRequest updateRequest) {
        ApiResponse<Collection> response = collectionService.modifyCollection(collectionId, updateRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @DeleteMapping
    public ResponseEntity<ApiResponse<String>>deleteCollection(@PathVariable Long collectionId){
        ApiResponse<String> response = collectionService.deleteCollection(collectionId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
   /* @GetMapping("/account/{cifId}")
    public ResponseEntity<ApiResponse<AccountResponse>> getAccountDetailsByCifId (@PathVariable Long cifId) {
        ApiResponse<AccountResponse> response = collectionService.getAccountDetailsByCifId(cifId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }*/


}
