package com.TradeFinance.bankguarantee.service;

import com.TradeFinance.bankguarantee.entity.BankGuarantee;
import com.TradeFinance.bankguarantee.dto.BankGuaranteeRequest;
import com.TradeFinance.dto.LetterOfCreditRequest;
import com.TradeFinance.bankguarantee.utils.enums.TransactionStatus;
import com.TradeFinance.util.ApiResponse;
import jakarta.transaction.Transactional;

import java.util.List;

public interface BankGuaranteeService {
    ApiResponse<String> createBankGuarantee(BankGuaranteeRequest bankGuaranteeRequest, String cifId, String nationalId, String accountNumber);

    ////////
//    @Transactional
//    ApiResponse<String> createBankGuarantee(BankGuaranteeRequest bankGuaranteeRequest, String cifId, String nationalId, String accountNumber);

    ApiResponse<String> createCopy(Long guaranteeId);
    ApiResponse<BankGuarantee> modifyBankGuarantee(Long guaranteeId, BankGuaranteeRequest bankGuaranteeRequest);
    ApiResponse<String> deleteBankGuarantee(Long guaranteeId);
    ApiResponse<BankGuarantee> getById(Long id);
    ApiResponse<BankGuarantee> getByGuaranteeNo(String guaranteeNo);
    ApiResponse<List<BankGuarantee>> getAll();
    ApiResponse<BankGuarantee> modifyBankGuaranteeByGuaranteeNo(String guaranteeNo, BankGuaranteeRequest bankGuaranteeRequest);
///////////




    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    ApiResponse<List<BankGuarantee>> getAllPendingTransactions();


    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    ApiResponse<List<BankGuarantee>> getAllRejectedTransactions();

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    ApiResponse<List<BankGuarantee>> getAllReturnedForReviewTransactions();

    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    ApiResponse<List<BankGuarantee>> getAllReturnedForApprovalTransactions();

    ApiResponse<List<BankGuarantee>> getAllApprovedTransactions();

    ApiResponse<TransactionStatus> getBankGuaranteeStatusByGuaranteeNo(String guaranteeNo);

    ApiResponse<String> deleteBankGuaranteeByGuaranteeNo(String guaranteeNo);
}
