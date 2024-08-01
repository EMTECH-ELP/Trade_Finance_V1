package com.TradeFinance.bankguarantee.service.Impl;




import com.TradeFinance.bankguarantee.entity.BankGuarantee;
import com.TradeFinance.bankguarantee.entity.BGDocumentsRequired;
import com.TradeFinance.bankguarantee.entity.BGShipmentAndGoods;
import com.TradeFinance.bankguarantee.repository.BankGuaranteeRepository;
import com.TradeFinance.bankguarantee.utils.enums.TransactionStatus;
import com.TradeFinance.bankguarantee.repository.DocumentsRequiredRepositoryBG;
import com.TradeFinance.bankguarantee.repository.ShipmentAndGoodsRepositoryBG;
import com.TradeFinance.bankguarantee.service.BankGuaranteeService;
import com.TradeFinance.dto.AccountResponse;
import com.TradeFinance.bankguarantee.dto.BankGuaranteeRequest;
//import com.TradeFinance.dto.ApplicantDto;
import com.TradeFinance.dto.BeneficiaryDto;
import com.TradeFinance.feign.AccountClientService;
import com.TradeFinance.util.ApiResponse;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Random;


import static com.TradeFinance.bankguarantee.mapper.BGDocumentsMapper.mapToDocumentsRequired;
import static com.TradeFinance.bankguarantee.mapper.BGShipmentAndGoodsMapper.mapToShipmentAndGoods;



@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
public class BankGuaranteeServiceImpl implements BankGuaranteeService {

    private final AccountClientService accountClientService;
    @Autowired
    private BankGuaranteeRepository bankGuaranteeRepository;
    @Autowired
    private DocumentsRequiredRepositoryBG documentsRequiredRepository;
    @Autowired
    private ShipmentAndGoodsRepositoryBG shipmentAndGoodsRepository;
    //private PaymentRepository paymentRepository;

/*
    @Override
    public ApiResponse<String> createBankGuarantee (BankGuaranteeRequest bankGuaranteeRequest) {

        String cifId = bankGuaranteeRequest.getCifId();
        String nationalId = bankGuaranteeRequest.getNationalId();
        String accountNumber = bankGuaranteeRequest.getAccountNumber();

        // Call the endpoint to retrieve account details
        ApiResponse<AccountResponse[]> response = accountClientService.getAccountDetailsByCifIdOrAccountNumberOrNationalId(
                cifId, accountNumber, nationalId);


        // Check if the response is successful
        if (response != null && response.getStatusCode() == HttpStatus.OK.value()) {
            AccountResponse[] accountResponses = response.getData();

            // Check if accountResponses is not null and has at least one element
            if (accountResponses != null && accountResponses.length > 0) {
                // Assuming you want to use the first account response
                AccountResponse accountResponse = accountResponses[0];
                System.out.println(response);
                ResponseEntity<?> beneficiaryResponseEntity = accountClientService.enterBeneficiaryDetails(bankGuaranteeRequest.getBeneficiaryDto());

                if (beneficiaryResponseEntity != null && beneficiaryResponseEntity.getStatusCode().is2xxSuccessful()) {

                    String guaranteeNo = generateGuaranteeNumber();
                    BGDocumentsRequired documentsRequired = mapToDocumentsRequired(bankGuaranteeRequest.getDocumentsRequiredDto());
                    documentsRequiredRepository.save(documentsRequired);

                    BGShipmentAndGoods shipmentAndGoods = mapToShipmentAndGoods(bankGuaranteeRequest.getShipmentAndGoodsDto());
                    shipmentAndGoodsRepository.save(shipmentAndGoods);

//                    PaymentSecurity paymentSecurity = mapToPaymentSecurity(bankGuaranteeRequest.getPaymentSecurityDto());
//                    paymentRepository.save(paymentSecurity);



                    BankGuarantee bankGuarantee = BankGuarantee.builder()
                            .status(TransactionStatus.PENDING_APPROVAL)
                            .guaranteeNo(guaranteeNo)
                            .guaranteeType(bankGuaranteeRequest.getGuaranteeType())
                            .purpose(bankGuaranteeRequest.getPurpose())
                            .additionalInformation(bankGuaranteeRequest.getAdditionalInformation())
                            .bankId(bankGuaranteeRequest.getBankId())
                            .guaranteeAmount(bankGuaranteeRequest.getGuaranteeAmount())
                            .guaranteeCurrency(bankGuaranteeRequest.getGuaranteeCurrency())
                            .currencyRate(bankGuaranteeRequest.getCurrencyRate())
                            .expiryDate(bankGuaranteeRequest.getExpiryDate())
                            .validityPeriod(bankGuaranteeRequest.getValidityPeriod())
                            .maxClaimPeriod(bankGuaranteeRequest.getMaxClaimPeriod())
                            .applicableRules(bankGuaranteeRequest.getApplicableRules())
                            .counterGuaranteeStatus(bankGuaranteeRequest.getCounterGuaranteeStatus())
                            //.guaranteeStatus(bankGuaranteeRequest.getGuaranteeStatus())
                            .chargesBorneBy(bankGuaranteeRequest.getChargesBorneBy())
                            .provisionAmount(bankGuaranteeRequest.getProvisionAmount())
                            .marginType(bankGuaranteeRequest.getMarginType())
                            .marginAccount(bankGuaranteeRequest.getMarginAccount())
                            .marginAmount(bankGuaranteeRequest.getMarginAmount())
                            .collectedMarginAmount(bankGuaranteeRequest.getCollectedMarginAmount())
                            .releasedMarginAmount(bankGuaranteeRequest.getReleasedMarginAmount())
                            .build();

                    bankGuaranteeRepository.save(bankGuarantee);
                    return new ApiResponse<>("Bank Guarantee created successfully", null, HttpStatus.CREATED.value());
                } else {
                    return new ApiResponse<>("Failed to retrieve account details with provided data", null, HttpStatus.NOT_FOUND.value());
                }
            } else {
                return new ApiResponse<>("Failed to retrieve account details", null, HttpStatus.NOT_FOUND.value());
            }
        } else {
            // Handle error response
            return new ApiResponse<>("Failed to retrieve account details", null, HttpStatus.NOT_FOUND.value());
        }
    }*/

////////
@Override
@Transactional
public ApiResponse<String> createBankGuarantee(BankGuaranteeRequest bankGuaranteeRequest, String cifId, String nationalId, String accountNumber) {
    ApiResponse<AccountResponse[]> response = accountClientService.getAccountDetailsByCifIdOrAccountNumberOrNationalId(
            cifId,
            accountNumber,
            nationalId
    );
    System.out.println("request   ============== "+ cifId + "acc no"+accountNumber + "natinal"+nationalId);


    BeneficiaryDto beneficiaryDto = bankGuaranteeRequest.getBeneficiaryDto();
    if (response != null && response.getStatusCode() == HttpStatus.OK.value()) {
        AccountResponse[] accountResponses = response.getData();

        // Check if accountResponses is not null and has at least one element
        if (accountResponses != null && accountResponses.length > 0) {
            // Assuming you want to use the first account response
            AccountResponse accountResponse = accountResponses[0];
            bankGuaranteeRequest.setAccountResponse(accountResponse);
//            System.out.println(response);

            // Check if beneficiaryDto is null before proceeding
            if (beneficiaryDto == null) {
                return new ApiResponse<>("Beneficiary details are missing", null, HttpStatus.BAD_REQUEST.value());
            }

            // Call the endpoint to retrieve account details
//        ApiResponse<AccountResponse[]> response = accountClientService.getAccountDetailsByCifIdOrAccountNumberOrNationalId(cifId, accountNumber, nationalId);


            // Check if the response is successful


            //  ResponseEntity<?> applicantResponseEntity = accountClientService.enterApplicantDetails(letterOfCreditRequest.getApplicantDto());
            ResponseEntity<?> beneficiaryResponseEntity = accountClientService.enterBeneficiaryDetails(bankGuaranteeRequest.getBeneficiaryDto());

            System.out.println("Beneficiary Details Saved"+beneficiaryResponseEntity);

//            if (applicantResponseEntity !=null&& applicantResponseEntity.getStatusCode().is2xxSuccessful()&&
            if ( beneficiaryResponseEntity != null && beneficiaryResponseEntity.getStatusCode().is2xxSuccessful()) {


                String guaranteeNo = generateGuaranteeNumber();
                BGDocumentsRequired documentsRequired = mapToDocumentsRequired(bankGuaranteeRequest.getDocumentsRequiredDto());
                documentsRequiredRepository.save(documentsRequired);

                BGShipmentAndGoods shipmentAndGoods = mapToShipmentAndGoods(bankGuaranteeRequest.getShipmentAndGoodsDto());
                shipmentAndGoodsRepository.save(shipmentAndGoods);

// TODO:               PaymentSecurity paymentSecurity = mapToPaymentSecurity(bankGuaranteeRequest.getPaymentSecurityDto());
//                paymentRepository.save(paymentSecurity);

                BankGuarantee bankGuarantee = BankGuarantee.builder()
                        .status(TransactionStatus.PENDING_APPROVAL)
                        .guaranteeNo(guaranteeNo)
                        .guaranteeType(bankGuaranteeRequest.getGuaranteeType())
                        .purpose(bankGuaranteeRequest.getPurpose())
                        .additionalInformation(bankGuaranteeRequest.getAdditionalInformation())
                        .bankId(bankGuaranteeRequest.getBankId())
                        .guaranteeAmount(bankGuaranteeRequest.getGuaranteeAmount())
                        .guaranteeCurrency(bankGuaranteeRequest.getGuaranteeCurrency())
                        .currencyRate(bankGuaranteeRequest.getCurrencyRate())
                        .expiryDate(bankGuaranteeRequest.getExpiryDate())
                        .validityPeriod(bankGuaranteeRequest.getValidityPeriod())
                        .maxClaimPeriod(bankGuaranteeRequest.getMaxClaimPeriod())
                        .applicableRules(bankGuaranteeRequest.getApplicableRules())
                        .counterGuaranteeStatus(bankGuaranteeRequest.getCounterGuaranteeStatus())
                        //.guaranteeStatus(bankGuaranteeRequest.getGuaranteeStatus())
                        .chargesBorneBy(bankGuaranteeRequest.getChargesBorneBy())
                        .provisionAmount(bankGuaranteeRequest.getProvisionAmount())
                        .marginType(bankGuaranteeRequest.getMarginType())
                        .marginAccount(bankGuaranteeRequest.getMarginAccount())
                        .marginAmount(bankGuaranteeRequest.getMarginAmount())
                        .collectedMarginAmount(bankGuaranteeRequest.getCollectedMarginAmount())
                        .releasedMarginAmount(bankGuaranteeRequest.getReleasedMarginAmount())
                        .shipmentAndGoodsBG(shipmentAndGoods)
                        .documentsRequiredBG(documentsRequired)
                        .build();

                //var resp = letterOfCreditRepository.save(letterOfCredit);
                var resp =  bankGuaranteeRepository.save(bankGuarantee);
                System.out.println("retyugjhk"+resp);
                return new ApiResponse<>("Bank Guarantee created successfully", null, HttpStatus.CREATED.value());
            } else {
                // Handle error response
                return new ApiResponse<>("Failed to enter beneficiary details", null, HttpStatus.INTERNAL_SERVER_ERROR.value());
            }
        } else {
            // Handle error response
            return new ApiResponse<>("No account found for CIF ID", null, HttpStatus.NOT_FOUND.value());
        }
    } else {
        // Handle error response
        return new ApiResponse<>("Failed to retrieve account details", null, HttpStatus.NOT_FOUND.value());
    }

}



////////////////
    @Override
    public ApiResponse<String> createCopy(Long guaranteeId) {
        return null;
    }

    private String generateGuaranteeNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(90000000) + 1009700; // Generate a random 6-digit number
        String bankGuaranteeNumber = "BG-" + randomNumber;
        return bankGuaranteeNumber;
    }

    @Override
    public ApiResponse<BankGuarantee> modifyBankGuarantee(Long guaranteeId, BankGuaranteeRequest bankGuaranteeRequest) {
        Optional<BankGuarantee> originalBGOptional = bankGuaranteeRepository.findById(guaranteeId);
        if (originalBGOptional.isPresent()) {
            BankGuarantee originalBG = originalBGOptional.get();

            originalBG.setGuaranteeType(bankGuaranteeRequest.getGuaranteeType());
            originalBG.setPurpose(bankGuaranteeRequest.getPurpose());
            originalBG.setAdditionalInformation(bankGuaranteeRequest.getAdditionalInformation());
            originalBG.setBankId(bankGuaranteeRequest.getBankId());
            originalBG.setGuaranteeAmount(bankGuaranteeRequest.getGuaranteeAmount());
            originalBG.setGuaranteeCurrency(bankGuaranteeRequest.getGuaranteeCurrency());
            originalBG.setCurrencyRate(bankGuaranteeRequest.getCurrencyRate());
            originalBG.setExpiryDate(bankGuaranteeRequest.getExpiryDate());
            originalBG.setValidityPeriod(bankGuaranteeRequest.getValidityPeriod());
            originalBG.setMaxClaimPeriod(bankGuaranteeRequest.getMaxClaimPeriod());
            originalBG.setApplicableRules(bankGuaranteeRequest.getApplicableRules());
            originalBG.setChargesBorneBy(bankGuaranteeRequest.getChargesBorneBy());
            originalBG.setProvisionAmount(bankGuaranteeRequest.getProvisionAmount());
            originalBG.setMarginType(bankGuaranteeRequest.getMarginType());
            originalBG.setMarginAccount(bankGuaranteeRequest.getMarginAccount());
            originalBG.setMarginAmount(bankGuaranteeRequest.getMarginAmount());
            originalBG.setCollectedMarginAmount(bankGuaranteeRequest.getCollectedMarginAmount());
            originalBG.setReleasedMarginAmount(bankGuaranteeRequest.getReleasedMarginAmount());

            return new ApiResponse<>("Bank Guarantee modified successfully", bankGuaranteeRepository.save(originalBG), 200);
        } else {
            throw new IllegalArgumentException("Bank Guarantee with ID " + guaranteeId + " not found.");
        }
    }




    @Override
    public ApiResponse<String> deleteBankGuarantee(Long guaranteeId) {
        if (bankGuaranteeRepository.existsById(guaranteeId)) {
            bankGuaranteeRepository.deleteById(guaranteeId);
            return new ApiResponse<>("Bank Guarantee deleted successfully", null, 201);
        } else {
            throw new IllegalArgumentException("Bank Guarantee with ID " + guaranteeId + " not found.");
        }
    }

    @Override
    public ApiResponse<BankGuarantee> getById(Long guaranteeId) {
        Optional<BankGuarantee> bankGuaranteeOptional = bankGuaranteeRepository.findById(guaranteeId);
        if (bankGuaranteeOptional.isPresent()) {
            BankGuarantee bankGuarantee = bankGuaranteeOptional.get();
            // Assuming the ApiResponse constructor expects (status, data, httpStatus)
            return new ApiResponse<>("success", bankGuarantee, HttpStatus.OK.value());
        } else {
            // Assuming the ApiResponse constructor expects (status, data, httpStatus)
            return new ApiResponse<>("error", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ApiResponse<BankGuarantee> getByGuaranteeNo(String guaranteeNo) {
        Optional<BankGuarantee> bankGuaranteeOptional = bankGuaranteeRepository.findByGuaranteeNo(guaranteeNo);
        if (bankGuaranteeOptional.isPresent()) {
            BankGuarantee bankGuarantee = bankGuaranteeOptional.get();
            return new ApiResponse<>("success", bankGuarantee, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ApiResponse<List<BankGuarantee>> getAll() {
        List<BankGuarantee> letterOfCredits = bankGuaranteeRepository.findAll();
        if (!letterOfCredits.isEmpty()) {
            return new ApiResponse<>("success", letterOfCredits, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", null, HttpStatus.NOT_FOUND.value());
        }
    }
/////GET PENDING TRANSACTIONS
    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public ApiResponse<List<BankGuarantee>> getAllPendingTransactions() {
        List<BankGuarantee> transactions = bankGuaranteeRepository.findByStatus(TransactionStatus.PENDING_APPROVAL);
        if (!transactions.isEmpty()) {
            return new ApiResponse<>("The following are the Pending Tickets", transactions, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("There are no Pending Tickets at the moment", null, HttpStatus.NOT_FOUND.value());
        }
    }
////MODIFY
    @Override
    @Transactional
    public ApiResponse<BankGuarantee> modifyBankGuaranteeByGuaranteeNo(String guaranteeNo, BankGuaranteeRequest bankGuaranteeRequest) {
        Optional<BankGuarantee> originalBGOptional = bankGuaranteeRepository.findByGuaranteeNo(guaranteeNo);
        if (originalBGOptional.isPresent()) {
            BankGuarantee originalBG = originalBGOptional.get();

            originalBG.setGuaranteeType(bankGuaranteeRequest.getGuaranteeType());
            originalBG.setPurpose(bankGuaranteeRequest.getPurpose());
            originalBG.setAdditionalInformation(bankGuaranteeRequest.getAdditionalInformation());
            originalBG.setBankId(bankGuaranteeRequest.getBankId());
            originalBG.setGuaranteeAmount(bankGuaranteeRequest.getGuaranteeAmount());
            originalBG.setGuaranteeCurrency(bankGuaranteeRequest.getGuaranteeCurrency());
            originalBG.setCurrencyRate(bankGuaranteeRequest.getCurrencyRate());
            originalBG.setExpiryDate(bankGuaranteeRequest.getExpiryDate());
            originalBG.setValidityPeriod(bankGuaranteeRequest.getValidityPeriod());
            originalBG.setMaxClaimPeriod(bankGuaranteeRequest.getMaxClaimPeriod());
            originalBG.setApplicableRules(bankGuaranteeRequest.getApplicableRules());
            originalBG.setChargesBorneBy(bankGuaranteeRequest.getChargesBorneBy());
            originalBG.setProvisionAmount(bankGuaranteeRequest.getProvisionAmount());
            originalBG.setMarginType(bankGuaranteeRequest.getMarginType());
            originalBG.setMarginAccount(bankGuaranteeRequest.getMarginAccount());
            originalBG.setMarginAmount(bankGuaranteeRequest.getMarginAmount());
            originalBG.setCollectedMarginAmount(bankGuaranteeRequest.getCollectedMarginAmount());
            originalBG.setReleasedMarginAmount(bankGuaranteeRequest.getReleasedMarginAmount());

            return new ApiResponse<>("Bank Guarantee modified successfully", bankGuaranteeRepository.save(originalBG), 200);
        } else {
            throw new IllegalArgumentException("Bank Guarantee with Number " +  guaranteeNo + " not found.");
        }
    }


 //
    @Override
    public ApiResponse<String> deleteBankGuaranteeByGuaranteeNo(String guaranteeNo) {
        Optional<BankGuarantee> bankGuaranteeOptional = bankGuaranteeRepository.findByGuaranteeNo(guaranteeNo);

        if (bankGuaranteeOptional.isPresent()) {
            BankGuarantee bankGuarantee = bankGuaranteeOptional.get();

            bankGuaranteeRepository.delete(bankGuarantee);

            return new ApiResponse<>("success", "Letter of Credit with LC number " + guaranteeNo + " has been deleted", HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", "Letter of Credit with LC number " + guaranteeNo + " not found", HttpStatus.NOT_FOUND.value());
        }
    }

///////APPROVALS
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public ApiResponse<List<BankGuarantee>> getAllRejectedTransactions() {
        List<BankGuarantee> transactions = bankGuaranteeRepository.findByStatus(TransactionStatus.REJECTED);
        if (!transactions.isEmpty()) {
            return new ApiResponse<>("The following are the rejected Tickets", transactions, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("There are no Rejected Tickets at the moment", null, HttpStatus.NOT_FOUND.value());
        }
    }
    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public ApiResponse<List<BankGuarantee>> getAllReturnedForReviewTransactions() {
        List<BankGuarantee> transactions = bankGuaranteeRepository.findByStatus(TransactionStatus.RETURNED_FOR_REVIEW);
        if (!transactions.isEmpty()) {
            return new ApiResponse<>("The following are the Returned for Review Tickets", transactions, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("There are No Tickets That have been Returned For Review", null, HttpStatus.NOT_FOUND.value());
        }
    }
    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public ApiResponse<List<BankGuarantee>> getAllReturnedForApprovalTransactions() {
        List<BankGuarantee> transactions = bankGuaranteeRepository.findByStatus(TransactionStatus.RETURNED_FOR_APPROVAL);
        if (!transactions.isEmpty()) {
            return new ApiResponse<>("The following are the Returned for Approval Tickets", transactions, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("There are No Tickets That have been Returned For Approval", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ApiResponse<TransactionStatus> getBankGuaranteeStatusByGuaranteeNo(String guaranteeNo) {
        Optional<BankGuarantee> bankGuaranteeOptional = bankGuaranteeRepository.findByGuaranteeNo(guaranteeNo);

        if (bankGuaranteeOptional.isPresent()) {
            BankGuarantee bankGuarantee = bankGuaranteeOptional.get();

            TransactionStatus status = bankGuarantee.getStatus();

            return new ApiResponse<>("success", status, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", null, HttpStatus.NOT_FOUND.value());
        }
    }
    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public ApiResponse<List<BankGuarantee>> getAllApprovedTransactions() {
        List<BankGuarantee> transactions = bankGuaranteeRepository.findByStatus(TransactionStatus.APPROVED);
        if (!transactions.isEmpty()) {
            return new ApiResponse<>("The following are the approved Tickets ", transactions, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("There are no Approved Tickets at the moment", null, HttpStatus.NOT_FOUND.value());
        }
    }
}