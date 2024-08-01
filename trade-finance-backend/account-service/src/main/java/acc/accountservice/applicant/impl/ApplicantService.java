package acc.accountservice.applicant.impl;

import com.TradeFinance.accountservice.account.AccountProjection;
import com.TradeFinance.accountservice.dto.*;
import com.TradeFinance.accountservice.util.ApiResponse;

import java.util.List;

public interface ApplicantService {
    BankResponse createAccount(ApplicantDto applicantDto);
    BankResponse balanceEnquiry(EnquiryRequest request);
    String nameEnquiry(EnquiryRequest request);
    BankResponse creditAccount(CreditDebitRequest request);
    BankResponse debitAccount(CreditDebitRequest request);
    BankResponse transfer(TransferRequest request);

    ApiResponse<List<AccountProjection>> getAccountDetailsByCifIdOrAccountNumberOrNationalId(String cifId, String accountNumber, String nationalId);

    ApiResponse<AccountProjection[]> getAccountDetailsAsArray(String cifId, String accountNumber, String nationalId);
}
