package com.TradeFinance.LetterOfCredit;

import com.TradeFinance.bankguarantee.dto.ErrorResponseDto;
import com.TradeFinance.util.ApiResponse;
import com.TradeFinance.dto.LetterOfCreditRequest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Tag(
        name = "REST APIs for Letter Of Credit in Trade Finance",
        description = "REST APIs in Trade Finance to CREATE, UPDATE/MODIFY, FETCH AND DELETE LC details"
)
@RestController
@RestControllerAdvice
@RequestMapping("/api/v1/LC")
@RequiredArgsConstructor
@CrossOrigin("*")
public class LetterOfCreditController {

    private final LetterOfCreditService letterOfCreditService;

    @Operation(
            summary = "Create Letter Of Credit REST API",
            description = "REST API to create new Letter Of Credit"
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
    @Valid
    public ResponseEntity<ApiResponse<LetterOfCreditRequest>> createLetterOfCredit(
            @RequestBody LetterOfCreditRequest letterOfCreditRequest,
            @RequestParam(required = false) String cifId,
            @RequestParam(required = false) String nationalId,
            @RequestParam(required = false) String accountNumber) throws Exception {

        System.out.println("create"+letterOfCreditRequest);

        ApiResponse<LetterOfCreditRequest> response = letterOfCreditService.createLCDetails(letterOfCreditRequest, cifId, nationalId, accountNumber);
        return ResponseEntity.ok(new ApiResponse<>(response.getMessage(), letterOfCreditRequest, response.getStatusCode()));
    }


    @PostMapping("/{letterOfCreditId}/copy")
    public ResponseEntity<ApiResponse<String>> createLetterOfCreditCopy(@PathVariable Long letterOfCreditId) {
        ApiResponse<String> response = letterOfCreditService.createCopy(letterOfCreditId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @Operation(
            summary = "Fetch LC Details REST API",
            description = "REST API to fetch LC details based on LC Id"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    @GetMapping("/{letterOfCreditId}/")
    public ResponseEntity<ApiResponse<LetterOfCredit>> getLetterOfCreditById(@PathVariable Long letterOfCreditId) {
        ApiResponse<LetterOfCredit> response = letterOfCreditService.getById(letterOfCreditId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @Operation(
            summary = "Fetch LC Details REST API",
            description = "REST API to fetch LC details Using LC Number"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    @GetMapping("/lcNumber/{lcNumber}")
    public ResponseEntity<ApiResponse<LetterOfCredit>> getLetterOfCreditByLcNumber(@PathVariable String lcNumber) {
        ApiResponse<LetterOfCredit> response = letterOfCreditService.getByLcNumber(lcNumber);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @GetMapping("/letterOfCreditNumber/{lcNumber}")
    public ResponseEntity<ApiResponse<LetterOfCredit>> getLC(@PathVariable String lcNumber) {
        ApiResponse<LetterOfCredit> response = letterOfCreditService.getByLcNumber(lcNumber);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @Operation(
            summary = "Fetch LC Details REST API",
            description = "REST API to fetch ALL LC"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    public ResponseEntity<ApiResponse<List<LetterOfCredit>>> getAllLetterOfCredits() {
        ApiResponse<List<LetterOfCredit>> response = letterOfCreditService.getAll();
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @Operation(
            summary = "Modify LC Details REST API",
            description = "REST API to modify LC details using LC Id"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    @PutMapping("/{letterOfCreditId}")
    public ResponseEntity<ApiResponse<LetterOfCredit>> modifyLetterOfCredit(@PathVariable Long letterOfCreditId, @RequestBody LetterOfCreditRequest updateRequest) {
        ApiResponse<LetterOfCredit> response = letterOfCreditService.modifyLetterOfCredit(letterOfCreditId, updateRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @Operation(
            summary = "Modify LC Details REST API",
            description = "REST API to modify LC details using LC Number"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    @PutMapping("/lcNumber/{lcNumber}")
    public ResponseEntity<ApiResponse<LetterOfCredit>> modifyLetterOfCreditByLcNumber(@PathVariable String lcNumber, @RequestBody LetterOfCreditRequest letterOfCreditRequest) {
        ApiResponse<LetterOfCredit> response = letterOfCreditService.modifyLetterOfCreditByLcNumber(lcNumber, letterOfCreditRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @Operation(
            summary = "Transfer LC Details REST API",
            description = "REST API to transfer LC to a Secondary Beneficiary Using LC Number"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    @PutMapping("/transfer/{lcNumber}")
    public ResponseEntity<ApiResponse<LetterOfCredit>> transferLoCToSecondaryBeneficiary(@PathVariable String lcNumber, @RequestBody LetterOfCreditRequest letterOfCreditRequest) {
        ApiResponse<LetterOfCredit> response = letterOfCreditService.transferLoCToSecondaryBeneficiary(lcNumber, letterOfCreditRequest);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @Operation(
            summary = "Approve LC Details REST API",
            description = "REST API to approve a new LC using LC Number "
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    @PutMapping("/approve")
    public ResponseEntity<ApiResponse<String>> approveLetterOfCredit(@RequestParam("lcNumber") String lcNumber) {
        // Call the service method with the lcNumber
        ApiResponse<String> response = letterOfCreditService.approveLetterOfCreditByNumber(lcNumber);
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }

    @Operation(
            summary = "Fetch LC Details REST API",
            description = "REST API to fetch LC details using LC Number "
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    @GetMapping("/letterOfCredit/status/{lcNumber}")
    public ResponseEntity<ApiResponse<TransactionStatus>> getLetterOfCreditStatusByLcNumber(@PathVariable String lcNumber) {
        ApiResponse<TransactionStatus> response = letterOfCreditService.getLetterOfCreditStatusByLcNumber(lcNumber);

        if (response.getData() != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @Operation(
            summary = "View all Pending LCs  REST API",
            description = "REST API to View all Pending LCs"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    public ResponseEntity<ApiResponse<List<LetterOfCredit>>> getAllPendingTransactions() {
        ApiResponse<List<LetterOfCredit>> response = letterOfCreditService.getAllPendingTransactions();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
    @Operation(
            summary = "View all Approved LCs  REST API",
            description = "REST API to View all Approved LCs"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    public ResponseEntity<ApiResponse<List<LetterOfCredit>>> getAllApprovedTransactions() {
        ApiResponse<List<LetterOfCredit>> response = letterOfCreditService.getAllApprovedTransactions();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
    @Operation(
            summary = "View all Rejected LCs  REST API",
            description = "REST API to View all Rejected LCs"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    public ResponseEntity<ApiResponse<List<LetterOfCredit>>> getAllRejectedTransactions() {
        ApiResponse<List<LetterOfCredit>> response = letterOfCreditService.getAllRejectedTransactions();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
    @Operation(
            summary = "View all Returned For Review LCs  REST API",
            description = "REST API to View all Returned For Review LCs"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    public ResponseEntity<ApiResponse<List<LetterOfCredit>>> getAllReturnedForReviewTransactions() {
        ApiResponse<List<LetterOfCredit>> response = letterOfCreditService.getAllReturnedForReviewTransactions();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
    @Operation(
            summary = "View all Returned For Approval LCs  REST API",
            description = "REST API to View all Returned For Approval LCs"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    public ResponseEntity<ApiResponse<List<LetterOfCredit>>> getAllReturnedForApprovalTransactions() {
        ApiResponse<List<LetterOfCredit>> response = letterOfCreditService.getAllReturnedForApprovalTransactions();
        return new ResponseEntity<>(response, HttpStatus.valueOf(response.getStatusCode()));
    }
    @Operation(
            summary = "Approve LC using Status  REST API",
            description = "REST API to Approve All LCs with Transaction Status PENDING_APPROVAL"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    @PutMapping("/letterOfCredits/approve/{status}")
    public ResponseEntity<ApiResponse<List<LetterOfCredit>>> approveLetterOfCreditsByStatus(@PathVariable String status) {
        ApiResponse<List<LetterOfCredit>> response = letterOfCreditService.approveLetterOfCreditByStatus(status);

        if (response.getData() != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }

    @Operation(
            summary = "Delete LC REST API",
            description = "REST API to Delete  an LC Using LC ID"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    @DeleteMapping("/{letterOfCreditId}")
    public ResponseEntity<ApiResponse<String>> deleteLetterOfCredit(@PathVariable Long letterOfCreditId) {
        ApiResponse<String> response = letterOfCreditService.deleteLetterOfCredit(letterOfCreditId);
        return ResponseEntity.status(response.getStatusCode()).body(response);
    }
    @Operation(
            summary = "Delete LC REST API",
            description = "REST API to Delete  an LC Using LC Number"
    )
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(
                    responseCode = "200",
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
    @DeleteMapping("/letterOfCredit/{lcNumber}")
    public ResponseEntity<ApiResponse<String>> deleteLetterOfCreditByLcNumber(@PathVariable String lcNumber) {
        ApiResponse<String> response = letterOfCreditService.deleteLetterOfCreditByLcNumber(lcNumber);

        if (response.getData() != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping("/softDelete/{lcNumber}")
    public ResponseEntity<ApiResponse<String>> softDeleteLetterOfCreditByLcNumber(@PathVariable String lcNumber) {
        ApiResponse<String> response = letterOfCreditService.deleteLetterOfCreditByLcNumber(lcNumber);

        if (response.getData() != null) {
            return new ResponseEntity<>(response, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
}

