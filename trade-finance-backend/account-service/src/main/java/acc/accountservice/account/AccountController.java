package acc.accountservice.account;

import com.TradeFinance.accountservice.account.impl.AccountService;
import com.TradeFinance.accountservice.applicant.ApplicantServiceImpl;
import com.TradeFinance.accountservice.applicant.impl.ApplicantService;
import com.TradeFinance.accountservice.dto.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/account")
@AllArgsConstructor
@Tag(name = "account Controller")
@CrossOrigin(origins = "*")  
public class AccountController {
    @Autowired
    ApplicantService applicantService;
    @Autowired
    ApplicantServiceImpl applicantServiceImpl;


    @Operation(
            summary = "Creating a new applicant Account",
            description = "Creating a new applicant and assigning an account Id"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http status 201 Created"
    )

    @PostMapping("/create")
    public BankResponse createAccount(@RequestBody ApplicantDto applicantDto) {
        AccountService.createAccount(applicantDto);

        return applicantService.createAccount(applicantDto);
    }

    @Operation(
            summary = "balance Enquiry",
            description = "Enquiring the Account Balance"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 Success"
    )
    @GetMapping("balanceEnquiry")
    public BankResponse balanceEnquiry(@RequestBody EnquiryRequest request) {
        return applicantService.balanceEnquiry(request);
    }

    @Operation(
            summary = "name Enquiry",
            description = "Enquiring the Account Name given the account Number"
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200 Success"
    )

    @GetMapping("nameEnquiry")
    public String nameEnquiry(@RequestBody EnquiryRequest request) {

        return applicantService.nameEnquiry(request);
    }

    @Operation(
            summary = "Crediting an Account",
            description = "Credit an account "
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200  Credit Success"
    )
    @PostMapping("credit")
    public BankResponse creditAccount(@RequestBody CreditDebitRequest request) {
        return applicantService.creditAccount(request);

}
    @Operation(
            summary = "Debiting an Account",
            description = "Debit an account "
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200  Debit Success"
    )
    @PostMapping("debit")
    public BankResponse debitAccount(@RequestBody CreditDebitRequest request){
        return applicantService.debitAccount(request);
    }
    @Operation(
            summary = "Transfer of funds",
            description = "Transfer of funds in accounts "
    )
    @ApiResponse(
            responseCode = "200",
            description = "Http status 200  Transfer Success"
    )
    @PostMapping("transfer")
    public BankResponse transfer(@RequestBody TransferRequest request){

    return applicantService.transfer(request);
    }

    @ApiResponse(
            responseCode = "200 ok",
            description = "Account retrieved successfully"
    )

    @GetMapping("/account-details")
    public com.TradeFinance.accountservice.util.ApiResponse<List<AccountProjection>> getAccountDetailsByCifIdOrAccountNumberOrNationalId(@RequestParam(required = false) String cifId,
                                                                                                                                         @RequestParam(required = false) String accountNumber, @RequestParam(required = false) String nationalId) {
        return applicantServiceImpl.getAccountDetailsByCifIdOrAccountNumberOrNationalId(cifId, accountNumber, nationalId);

    }

}








