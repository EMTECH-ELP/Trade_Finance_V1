package com.TradeFinance.bankguarantee.controller;

import com.TradeFinance.bankguarantee.entity.BankGuarantee;
import com.TradeFinance.bankguarantee.utils.enums.TransactionStatus;
import com.TradeFinance.bankguarantee.dto.ErrorResponseDto;
import com.TradeFinance.bankguarantee.entity.BankGuarantee;
import com.TradeFinance.bankguarantee.service.BankGuaranteeService;
import com.TradeFinance.dto.AccountResponse;
import com.TradeFinance.bankguarantee.dto.BankGuaranteeRequest;
import com.TradeFinance.feign.AccountClientService;
import com.TradeFinance.util.ApiResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "CRUD REST APIs for Bank Guarantee in Trande Finance",
        description = "CRUD REST APIs in Trade Finance to CREATE, UPDATE, FETCH AND DELETE Bank Guarantee details"
)
@RestController
@RequestMapping("/api/BG")
@RequiredArgsConstructor
public class BankGuaranteeController {

    private final BankGuaranteeService bankGuaranteeService;
    private AccountClientService accountClientService;

//    @GetMapping("/account/{cifId}")
//    public AccountResponse getAccountDetails(@PathVariable("cifId") String cifId) {
//        return accountClientService.getAccountDetailsByCifId(cifId);
//    }
    @Operation(
            summary = "Create Bank Guarantee REST API",
            description = "REST API to create new Bank Guarantee in Trade Finance"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<String>> createBankGuarantee(@RequestBody BankGuaranteeRequest bankGuaranteeRequest,
                                                                   @RequestParam(required = false) String cifId,
                                                                   @RequestParam(required = false) String nationalId,
                                                                   @RequestParam(required = false) String accountNumber) {
        ApiResponse<String> response = bankGuaranteeService.createBankGuarantee(bankGuaranteeRequest, cifId, nationalId, accountNumber);
        return ResponseEntity.ok(new ApiResponse<>("BankGuarantee created successfully", null, HttpStatus.CREATED.value()));
    }
    @Operation(
            summary = "Create a copy of Bank Guarantee REST API",
            description = "REST API to create a copy of Bank Guarantee in Trade Finance"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status CREATED"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PostMapping("/{guaranteeId}/copy")
    public ResponseEntity<ApiResponse<String>> createBankGuaranteeCopy(@PathVariable Long guaranteeId) {
        ApiResponse<String> response = bankGuaranteeService.createCopy(guaranteeId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
//        return ResponseEntity
//                .status(HttpStatus.CREATED)
//                .body(new ResponseDto(GuaranteeConstants.STATUS_201, GuaranteeConstants.MESSAGE_201));

    }


    @Operation(
            summary = "Fetch Bank Guarantee Details REST API",
            description = "REST API to fetch Bank Guarantee details based on Bank Guarantee Id"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status OK"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<BankGuarantee>> getBankGuaranteeById(@PathVariable Long guaranteeId) {
        ApiResponse<BankGuarantee> response = bankGuaranteeService.getById(guaranteeId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @Operation(
            summary = "Fetch Bank Guarantee Details REST API",
            description = "REST API to fetch Bank Guarantee details based on Bank Guarantee No"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status OK"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/guaranteeNo/{guaranteeNo}")
    public ResponseEntity<ApiResponse<BankGuarantee>> getBankGuaranteeByGuaranteeNo(@PathVariable String guaranteeNo) {
        ApiResponse<BankGuarantee> response = bankGuaranteeService.getByGuaranteeNo(guaranteeNo);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @Operation(
            summary = "Fetch all Bank Guarantees REST API",
            description = "REST API to fetch all Bank Guarantee"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status OK"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/all")
    public ResponseEntity<ApiResponse<List<BankGuarantee>>> getAllBankGuarantee() {
        ApiResponse<List<BankGuarantee>> response = bankGuaranteeService.getAll();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }


    @Operation(
            summary = "Update Bank Guarantee Details REST API",
            description = "REST API to update Bank Guarantee details based on a Guarantee Id"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status OK"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PutMapping("/{guaranteeId}")
    public ResponseEntity<ApiResponse<BankGuarantee>> modifyBankGuarantee(@PathVariable Long guaranteeId, @RequestBody BankGuaranteeRequest updateRequest) {
        ApiResponse<BankGuarantee> response = bankGuaranteeService.modifyBankGuarantee(guaranteeId, updateRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }

    @Operation(
            summary = "Update Bank Guarantee Details REST API",
            description = "REST API to update Bank Guarantee details based on a Guarantee No"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status OK"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @PutMapping("/guaranteeNo/{guaranteeNo}")
    public ResponseEntity<ApiResponse<BankGuarantee>> modifyBankGuaranteeByGuaranteeNo(@PathVariable String guaranteeNo, @RequestBody BankGuaranteeRequest bankGuaranteeRequest) {
        ApiResponse<BankGuarantee> response = bankGuaranteeService.modifyBankGuaranteeByGuaranteeNo(guaranteeNo, bankGuaranteeRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @Operation(
            summary = "Delete Bank Guarantee Details REST API",
            description = "REST API to delete Customer &  Account details based on Guarantee Id"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status OK"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "417",
                    description = "Expectation Failed"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @DeleteMapping("/{guaranteeId}")
    public ResponseEntity<ApiResponse<String>> deleteBankGuarantee(@PathVariable Long guaranteeId) {
        ApiResponse<String> response = bankGuaranteeService.deleteBankGuarantee(guaranteeId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @Operation(
            summary = "Delete BG REST API",
            description = "REST API to Delete  a BG Using Guarantee Number"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status OK"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @DeleteMapping("/BankGuarantee/{guaranteeNo}")
    public ResponseEntity<ApiResponse<String>> deleteBankGuaranteeByGuaranteeNo(@PathVariable String guaranteeNo) {
        ApiResponse<String> response = bankGuaranteeService.deleteBankGuaranteeByGuaranteeNo(guaranteeNo);

        if (response.getData() != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "Fetch BG Details REST API",
            description = "REST API to fetch BG details using Guarantee Number "
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status OK"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/BankGuarantee/status/{guaranteeNo}")
    public ResponseEntity<ApiResponse<TransactionStatus>> getBankGuaranteeStatusByGuaranteeNo(@PathVariable String guaranteeNo) {
        ApiResponse<TransactionStatus> response = bankGuaranteeService.getBankGuaranteeStatusByGuaranteeNo(guaranteeNo);

        if (response.getData() != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @Operation(
            summary = "View all Pending BGs  REST API",
            description = "REST API to View all Pending BGs"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status OK"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/Pending Tickets")
    public ResponseEntity<ApiResponse<List<BankGuarantee>>> getAllPendingTransactions() {
        ApiResponse<List<BankGuarantee>> response = bankGuaranteeService.getAllPendingTransactions();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
    @Operation(
            summary = "View all Approved BGs  REST API",
            description = "REST API to View all Approved BGs"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status OK"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/Approved Tickets")
    public ResponseEntity<ApiResponse<List<BankGuarantee>>> getAllApprovedTransactions() {
        ApiResponse<List<BankGuarantee>> response = bankGuaranteeService.getAllApprovedTransactions();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
    @Operation(
            summary = "View all Rejected BGs REST API",
            description = "REST API to View all Rejected BGs"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status OK"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/Rejected Tickets")
    public ResponseEntity<ApiResponse<List<BankGuarantee>>> getAllRejectedTransactions() {
        ApiResponse<List<BankGuarantee>> response = bankGuaranteeService.getAllRejectedTransactions();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
    @Operation(
            summary = "View all Returned BGs For Review REST API",
            description = "REST API to View all Returned BGs For Review "
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status OK"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/Returned For Review Tickets ")
    public ResponseEntity<ApiResponse<List<BankGuarantee>>> getAllReturnedForReviewTransactions() {
        ApiResponse<List<BankGuarantee>> response = bankGuaranteeService.getAllReturnedForReviewTransactions();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
    @Operation(
            summary = "View all Returned For Approval BGs  REST API",
            description = "REST API to View all Returned For Approval BGs"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "201",
                    description = "HTTP Status OK"
            ),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "500",
                    description = "HTTP Status Internal Server Error",
                    content = @Content(
                            schema = @Schema(implementation = ErrorResponseDto.class)
                    )
            )
    }
    )
    @GetMapping("/Returned For Approval Tickets ")
    public ResponseEntity<ApiResponse<List<BankGuarantee>>> getAllReturnedForApprovalTransactions() {
        ApiResponse<List<BankGuarantee>> response = bankGuaranteeService.getAllReturnedForApprovalTransactions();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }




}



