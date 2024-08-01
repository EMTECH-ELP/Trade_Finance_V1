package com.TradeFinance.LetterOfCredit;

import com.TradeFinance.util.ApiResponse;
import com.TradeFinance.dto.LetterOfCreditRequest;

import java.util.List;

public interface LetterOfCreditService {
    //ApiResponse<String> createLetterOfCredit(LetterOfCreditRequest letterOfCreditRequest);

   //ApiResponse<LetterOfCredit> createLetterOfCredit(LetterOfCreditRequest letterOfCreditRequest, String cifId, String nationalId, String accountNumber);
    //public ApiResponse<LetterOfCredit> createLetterOfCredit(LetterOfCreditRequest letterOfCreditRequest, String cifId, String nationalId, String accountNumber);

   // ApiResponse<LetterOfCredit> createLetterOfCredit(LetterOfCreditRequest letterOfCreditRequest, Optional<String> cifId, Optional<String> nationalId, Optional<String> accountNumber);

    //ApiResponse<LetterOfCredit> createLC(LetterOfCreditRequest letterOfCreditRequest, String cifId, String nationalId, String accountNumber);

   // ApiResponse<LetterOfCredit> createLetterOfCredit(LetterOfCreditRequest letterOfCreditRequest, String cifId, String nationalId, String accountNumber);

   // ApiResponse<LetterOfCredit> createLCDetails(LetterOfCreditRequest letterOfCreditRequest, String cifId, String nationalId, String accountNumber);

    public ApiResponse<LetterOfCreditRequest> createLCDetails(LetterOfCreditRequest letterOfCreditRequest, String cifId, String nationalId, String accountNumber) throws Exception;

    ApiResponse<String> createCopy(Long letterOfCreditId);
    ApiResponse<LetterOfCredit> modifyLetterOfCredit(Long letterOfCreditId, LetterOfCreditRequest letterOfCreditRequest);
    ApiResponse<String> deleteLetterOfCredit(Long letterOfCreditId);
    ApiResponse<LetterOfCredit> getById(Long id);
    ApiResponse<LetterOfCredit> getByLcNumber(String lcNumber);
    ApiResponse<List<LetterOfCredit>> getAll();

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    ApiResponse<List<LetterOfCredit>> getAllPendingTransactions();

    ApiResponse<LetterOfCredit> modifyLetterOfCreditByLcNumber(String lcNumber, LetterOfCreditRequest letterOfCreditRequest);

    ApiResponse<LetterOfCredit> transferLoCToSecondaryBeneficiary(String lcNumber, LetterOfCreditRequest letterOfCreditRequest);

    ApiResponse<String> approveLetterOfCreditByNumber(String lcNumber);

    ApiResponse<String> approveLetterOfCreditByStatus(String lcNumber, String status);

    ApiResponse<TransactionStatus> getLetterOfCreditStatusByLcNumber(String lcNumber);

    ApiResponse<List<LetterOfCredit>> findByStatus(String status);

    ApiResponse<List<LetterOfCredit>> approveLetterOfCreditByStatus(String status);

    ApiResponse<String> deleteLetterOfCreditByLcNumber(String lcNumber);

    ApiResponse<String> softDeleteLetterOfCreditByLcNumber(String lcNumber);

    ApiResponse<List<LetterOfCredit>> getAllApprovedTransactions();

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    ApiResponse<List<LetterOfCredit>> getAllRejectedTransactions();

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    ApiResponse<List<LetterOfCredit>> getAllReturnedForReviewTransactions();

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    ApiResponse<List<LetterOfCredit>> getAllReturnedForApprovalTransactions();

    ApiResponse<LetterOfCreditRequest> getAllLetterOfCreditRequests();

    //ApiResponse<String> getByLcNumber1(String lcNumber);

    //String generateMT700(Long letterOfCreditId);
}
