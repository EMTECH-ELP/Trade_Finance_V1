package acc.accountservice.account.impl;

import com.TradeFinance.accountservice.dto.ApplicantDto;
import com.TradeFinance.accountservice.dto.BankResponse;
import com.TradeFinance.accountservice.dto.CreditDebitRequest;
import com.TradeFinance.accountservice.dto.EnquiryRequest;
import com.TradeFinance.accountservice.exception.CustomerAlreadyExistsException;

public interface AccountService {
    /**
     * @param applicantDto - ApplicantDto Object
     */
    static void createAccount(ApplicantDto applicantDto) throws CustomerAlreadyExistsException {

    }

    BankResponse balanceEnquiry(EnquiryRequest request);

    String nameEnquiry(EnquiryRequest request);


    BankResponse creditAccount(CreditDebitRequest request);
}

