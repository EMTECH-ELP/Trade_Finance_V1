package com.TradeFinance.LetterOfCredit.Impl;

import com.TradeFinance.LetterOfCredit.*;
import com.TradeFinance.LetterOfCredit.DocumentsAndShipment.DocumentsRequired;
import com.TradeFinance.LetterOfCredit.DocumentsAndShipment.DocumentsRequiredRepository;
import com.TradeFinance.LetterOfCredit.DocumentsAndShipment.ShipmentAndGoods;
import com.TradeFinance.LetterOfCredit.DocumentsAndShipment.ShipmentAndGoodsRepository;
import com.TradeFinance.LetterOfCredit.applicant.Applicant;
import com.TradeFinance.LetterOfCredit.applicant.ApplicantRepository;
import com.TradeFinance.LetterOfCredit.beneficiary.Beneficiary;
import com.TradeFinance.LetterOfCredit.beneficiary.BeneficiaryRepository;
import com.TradeFinance.LetterOfCredit.collateral.PaymentRepository;
import com.TradeFinance.LetterOfCredit.collateral.PaymentSecurity;
import com.TradeFinance.dto.AccountResponse;
import com.TradeFinance.dto.BeneficiaryDto;
import com.TradeFinance.dto.LetterOfCreditRequest;
import com.TradeFinance.feign.AccountClientService;
import com.TradeFinance.util.ApiResponse;
import jakarta.transaction.Transactional;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Random;
import static com.TradeFinance.LetterOfCredit.DocumentsAndShipment.MapperUtil.mapToApplicant;
import static com.TradeFinance.LetterOfCredit.DocumentsAndShipment.MapperUtil.mapToBeneficiary;
import static com.TradeFinance.LetterOfCredit.DocumentsAndShipment.MapperUtil.mapToDocumentsRequired;
import static com.TradeFinance.LetterOfCredit.DocumentsAndShipment.MapperUtil.mapToPaymentSecurity;
import static com.TradeFinance.LetterOfCredit.DocumentsAndShipment.MapperUtil.mapToShipmentAndGoods;

@Service
@RequiredArgsConstructor
@Slf4j
@Transactional
@NoArgsConstructor(force = true)

public class LetterOfCreditServiceImpl implements LetterOfCreditService {

    private final AccountClientService accountClientService;
    @Autowired
    private LetterOfCreditRepository letterOfCreditRepository;
    @Autowired
    private DocumentsRequiredRepository documentsRequiredRepository;
    @Autowired
    private ShipmentAndGoodsRepository shipmentAndGoodsRepository;
    @Autowired
    private PaymentRepository paymentRepository;
    @Autowired
    private ApplicantRepository applicantRepository;
    @Autowired
    private BeneficiaryRepository beneficiaryRepository;
    private Object cifId;

    private final ApplicationContext applicationContext;
    private MT700FactoryBean mt700FactoryBean;

//    public LetterOfCreditServiceImpl(ApplicationContext applicationContext, MT700FactoryBean mt700FactoryBean, AccountClientService accountClientService, MT700FactoryBean mt700FactoryBean1) {
//        this.applicationContext = applicationContext;
//        this.accountClientService = accountClientService;
//        this.mt700FactoryBean = mt700FactoryBean1;
//        this.init(mt700FactoryBean);
//    }
@Autowired
public LetterOfCreditServiceImpl(ApplicationContext applicationContext,
                                 MT700FactoryBean mt700FactoryBean,
                                 AccountClientService accountClientService) {
    this.applicationContext = applicationContext;
    this.accountClientService = accountClientService;
    this.mt700FactoryBean = mt700FactoryBean;
}
    public void init(MT700FactoryBean mt700FactoryBean) {
        this.mt700FactoryBean = mt700FactoryBean;
    }
    @Override
    @Transactional
    public ApiResponse<LetterOfCreditRequest> createLCDetails(LetterOfCreditRequest letterOfCreditRequest, String cifId, String nationalId, String accountNumber) throws Exception {
        ApiResponse<AccountResponse[]> response = accountClientService.getAccountDetailsByCifIdOrAccountNumberOrNationalId(cifId, accountNumber, nationalId);
        System.out.println("request   ============== " + cifId + "acc no" + accountNumber + "natinal" + nationalId);
        Applicant applicant = null;

        if (response!= null && response.getStatusCode() == HttpStatus.OK.value()) {
            AccountResponse[] accountResponses = response.getData();

            // Check if accountResponses is not null and has at least one element
            if (accountResponses!= null && accountResponses.length > 0) {
                // Assuming you want to use the first account response
                AccountResponse accountResponse = accountResponses[0];
                letterOfCreditRequest.setAccountResponse(accountResponse);

                if (letterOfCreditRequest.getApplicantDto()!= null) {
                    applicant = mapToApplicant(letterOfCreditRequest.getApplicantDto());
                    applicantRepository.save(applicant);
                } else {
                    // Handle the case where ApplicantDto is null
                    // You may choose to log a warning, skip saving the BGApplicant, or set a default BGApplicant
                    System.out.println("ApplicantDTO is null, skipping BGApplicant creation.");
                }
//                BGApplicant applicant = mapToApplicant(letterOfCreditRequest.getApplicantDto());
//                applicantRepository.save(applicant);
                Beneficiary beneficiary = mapToBeneficiary(letterOfCreditRequest.getBeneficiaryDto());
                beneficiaryRepository.save(beneficiary);

                // Save other required entities
                DocumentsRequired documentsRequired = mapToDocumentsRequired(letterOfCreditRequest.getDocumentsRequiredDto());
                documentsRequiredRepository.save(documentsRequired);

                ShipmentAndGoods shipmentAndGoods = mapToShipmentAndGoods(letterOfCreditRequest.getShipmentAndGoodsDto());
                shipmentAndGoodsRepository.save(shipmentAndGoods);

                PaymentSecurity paymentSecurity = mapToPaymentSecurity(letterOfCreditRequest.getPaymentSecurityDto());
                paymentRepository.save(paymentSecurity);

                // Create and save the LetterOfCredit
                String letterOfCreditNumber = generateLetterOfCreditNumber();
                LetterOfCredit letterOfCredit = LetterOfCredit.builder()
                        .status(TransactionStatus.PENDING_APPROVAL)
                        .isDeleted(false)
                        .lcNumber(letterOfCreditNumber)
                        .lcType(letterOfCreditRequest.getLcType())
                        .applicableRules(letterOfCreditRequest.getApplicableRules())
                        .issueDate(letterOfCreditRequest.getIssueDate())
                        .expiryDate(letterOfCreditRequest.getExpiryDate())
                        .tenor(letterOfCreditRequest.getTenor())
                        .transferCurrencyCode(letterOfCreditRequest.getTransferCurrencyCode())
                        .transferable(letterOfCreditRequest.getTransferable())
                        .negotiationPeriod(letterOfCreditRequest.getNegotiationPeriod())
                        .chargesBorneBy(letterOfCreditRequest.getChargesBorneBy())
                        .amount(letterOfCreditRequest.getAmount())
                        .currencyCode(letterOfCreditRequest.getCurrencyCode())
                        .createdBy(letterOfCreditRequest.getCreatedBy())
                        .creationDate(letterOfCreditRequest.getCreationDate())
                        .approvalDate(letterOfCreditRequest.getApprovalDate())
                        .approvedBy(letterOfCreditRequest.getApprovedBy())
                        .confirm(letterOfCreditRequest.getConfirm())
                        .advise(letterOfCreditRequest.getAdvise())
                        .shipmentAndGoods(shipmentAndGoods)
                        .documentsRequired(documentsRequired)
                        .paymentSecurity(paymentSecurity)
                        .applicant(applicant)
                        .beneficiary(beneficiary)
                        .build();

                var resp = letterOfCreditRepository.save(letterOfCredit);
                MT700 mt700Instance = createMT700Instance();
                System.out.println("retyugjhk" + resp);
                return new ApiResponse<>("LetterOfCredit created successfully", letterOfCreditRequest, HttpStatus.CREATED.value());
            } else {
                // Handle error response
                return new ApiResponse<>("No account found for CIF ID", null, HttpStatus.NOT_FOUND.value());
            }
        } else {
            // Handle error response
            return new ApiResponse<>("Failed to retrieve account details", null, HttpStatus.NOT_FOUND.value());
        }
    }

    public MT700 createMT700Instance() throws Exception {
        return mt700FactoryBean.getObject();
    }

    public ApiResponse<String> createCopy(Long letterOfCreditId) {
        return null;
    }

    private String generateLetterOfCreditNumber() {
        Random random = new Random();
        int randomNumber = random.nextInt(90000000) + 10209700; // Generate a random 6-digit number
        String letterOfCreditNumber = "LC-" + randomNumber;
        return letterOfCreditNumber;
    }

    @Override
    public ApiResponse<LetterOfCredit> modifyLetterOfCredit(Long letterOfCreditId, LetterOfCreditRequest letterOfCreditRequest) {
        Optional<LetterOfCredit> originalLetterOfCreditOptional = letterOfCreditRepository.findById(letterOfCreditId);
        if (originalLetterOfCreditOptional.isPresent()) {
            LetterOfCredit originalLetterOfCredit = originalLetterOfCreditOptional.get();

            originalLetterOfCredit.setLcType(letterOfCreditRequest.getLcType());
            originalLetterOfCredit.setApplicableRules(letterOfCreditRequest.getApplicableRules());
            originalLetterOfCredit.setCurrencyCode(letterOfCreditRequest.getCurrencyCode());
            originalLetterOfCredit.setAmount(letterOfCreditRequest.getAmount());
            originalLetterOfCredit.setExpiryDate(letterOfCreditRequest.getExpiryDate());
            originalLetterOfCredit.setChargesBorneBy(letterOfCreditRequest.getChargesBorneBy());
            originalLetterOfCredit.setConfirm(letterOfCreditRequest.getConfirm());
            originalLetterOfCredit.setAdvise(letterOfCreditRequest.getAdvise());
            originalLetterOfCredit.setNegotiationPeriod(letterOfCreditRequest.getNegotiationPeriod());
            originalLetterOfCredit.setIssueDate(letterOfCreditRequest.getIssueDate());
            originalLetterOfCredit.setTenor(letterOfCreditRequest.getTenor());
            originalLetterOfCredit.setTransferable(letterOfCreditRequest.getTransferable());

            return new ApiResponse<>("Letter of Credit modified successfully", letterOfCreditRepository.save(originalLetterOfCredit), 200);
        } else {
            throw new IllegalArgumentException("Letter of Credit with ID " + letterOfCreditId + " not found.");
        }
    }


    @Override
    public ApiResponse<String> deleteLetterOfCredit(Long letterOfCreditId) {
        if (letterOfCreditRepository.existsById(letterOfCreditId)) {
            letterOfCreditRepository.deleteById(letterOfCreditId);
            return new ApiResponse<>("Letter of Credit deleted successfully", null, 200);
        } else {
            throw new IllegalArgumentException("Letter of Credit with ID " + letterOfCreditId + " not found.");
        }
    }

    @Override
    public ApiResponse<LetterOfCredit> getById(Long letterOfCreditId) {
        Optional<LetterOfCredit> letterOfCreditOptional = letterOfCreditRepository.findById(letterOfCreditId);
        if (letterOfCreditOptional.isPresent()) {
            LetterOfCredit letterOfCredit = letterOfCreditOptional.get();
            // Assuming the ApiResponse constructor expects (status, data, httpStatus)
            return new ApiResponse<>("success", letterOfCredit, HttpStatus.OK.value());
        } else {
            // Assuming the ApiResponse constructor expects (status, data, httpStatus)
            return new ApiResponse<>("error", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ApiResponse<LetterOfCredit> getByLcNumber(String lcNumber) {
        Optional<LetterOfCredit> letterOfCreditOptional = letterOfCreditRepository.findByLcNumber(lcNumber);
        if (letterOfCreditOptional.isPresent()) {
            //ResponseEntity<ApiResponse<List<ApplicantDto>>> getAccountDetailsByCifId(@PathVariable String cifId);
            LetterOfCredit letterOfCredit = letterOfCreditOptional.get();
            return new ApiResponse<>("success", letterOfCredit, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ApiResponse<List<LetterOfCredit>> getAll() {
        List<LetterOfCredit> letterOfCredits = letterOfCreditRepository.findAll();
        if (!letterOfCredits.isEmpty()) {
            return new ApiResponse<>("success", letterOfCredits, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public ApiResponse<List<LetterOfCredit>> getAllPendingTransactions() {
        List<LetterOfCredit> transactions = letterOfCreditRepository.findByStatus(TransactionStatus.PENDING_APPROVAL);
        if (!transactions.isEmpty()) {
            return new ApiResponse<>("The following are the Pending Tickets", transactions, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("There are no Pending Tickets at the moment", null, HttpStatus.NOT_FOUND.value());
        }
    }


    @Override
    @Transactional
    public ApiResponse<LetterOfCredit> modifyLetterOfCreditByLcNumber(String lcNumber, LetterOfCreditRequest letterOfCreditRequest) {
        Optional<LetterOfCredit> originalLetterOfCreditOptional = letterOfCreditRepository.findByLcNumber(lcNumber);
        if (originalLetterOfCreditOptional.isPresent()) {
            LetterOfCredit originalLetterOfCredit = originalLetterOfCreditOptional.get();

            originalLetterOfCredit.setLcType(letterOfCreditRequest.getLcType());
            originalLetterOfCredit.setApplicableRules(letterOfCreditRequest.getApplicableRules());
            originalLetterOfCredit.setCurrencyCode(letterOfCreditRequest.getCurrencyCode());
            originalLetterOfCredit.setAmount(letterOfCreditRequest.getAmount());
            originalLetterOfCredit.setExpiryDate(letterOfCreditRequest.getExpiryDate());
            originalLetterOfCredit.setChargesBorneBy(letterOfCreditRequest.getChargesBorneBy());
            originalLetterOfCredit.setConfirm(letterOfCreditRequest.getConfirm());
            originalLetterOfCredit.setAdvise(letterOfCreditRequest.getAdvise());
            originalLetterOfCredit.setNegotiationPeriod(letterOfCreditRequest.getNegotiationPeriod());
            originalLetterOfCredit.setIssueDate(letterOfCreditRequest.getIssueDate());
            originalLetterOfCredit.setTenor(letterOfCreditRequest.getTenor());
            originalLetterOfCredit.setTransferable(letterOfCreditRequest.getTransferable());

            return new ApiResponse<>("Letter of Credit modified successfully", letterOfCreditRepository.save(originalLetterOfCredit), 200);
        } else {
            throw new IllegalArgumentException("Letter of Credit with Number " + lcNumber + " not found.");
        }
    }


    @Override
    @Transactional
    public ApiResponse<LetterOfCredit> transferLoCToSecondaryBeneficiary(String lcNumber, LetterOfCreditRequest letterOfCreditRequest) {
        Optional<LetterOfCredit> originalLetterOfCreditOptional = letterOfCreditRepository.findByLcNumber(lcNumber);
        if (originalLetterOfCreditOptional.isPresent()) {
            LetterOfCredit originalLetterOfCredit = originalLetterOfCreditOptional.get();

            // Check if the LoC is transferable
            if (originalLetterOfCredit.getTransferable()) {
                // Call the account-service to create or update the secondary beneficiary details
                ResponseEntity<?> secondaryBeneficiaryResponseEntity = accountClientService.enterSecondaryBeneficiaryDetails(letterOfCreditRequest.getSecondaryBeneficiaryDto());
                if (secondaryBeneficiaryResponseEntity != null && secondaryBeneficiaryResponseEntity.getStatusCode().is2xxSuccessful()) {
                    // Proceed with modifying the LoC
                    originalLetterOfCredit.setTransferCurrencyCode(letterOfCreditRequest.getTransferCurrencyCode());
                    originalLetterOfCredit.setNewExpiryDate(letterOfCreditRequest.getNewExpiryDate());
                    originalLetterOfCredit.setTransferAmount(letterOfCreditRequest.getTransferAmount());

                    // Save the updated LetterOfCredit
                    LetterOfCredit updatedLoC = letterOfCreditRepository.save(originalLetterOfCredit);
                    return new ApiResponse<>("Letter of Credit Transferred successfully", updatedLoC, HttpStatus.OK.value());
                } else {
                    return new ApiResponse<>("Failed to retrieve secondary beneficiary details", null, HttpStatus.BAD_REQUEST.value());
                }
            } else {
                return new ApiResponse<>("LoC is not transferable", null, HttpStatus.FORBIDDEN.value());
            }
        } else {
            throw new IllegalArgumentException("Letter of Credit with Number " + lcNumber + " not found.");
        }
    }

    @Override
    public ApiResponse<String> approveLetterOfCreditByNumber(String lcNumber) {
        Optional<LetterOfCredit> optionalLetterOfCredit = letterOfCreditRepository.findByLcNumber(lcNumber);

        if (optionalLetterOfCredit.isPresent()) {
            LetterOfCredit letterOfCredit = optionalLetterOfCredit.get();
            List<String> fieldsToModify = new ArrayList<>();

            TransactionStatus newStatus;
            if (letterOfCredit.getStatus() == TransactionStatus.PENDING_APPROVAL || letterOfCredit.getStatus() == TransactionStatus.RETURNED_FOR_APPROVAL) {
                if (letterOfCredit.getAmount().compareTo(new BigDecimal("100000")) > 0) {
                    newStatus = TransactionStatus.RETURNED_FOR_REVIEW;
                    fieldsToModify.add("Amount");
                } else {
                    newStatus = TransactionStatus.APPROVED;
                }
            } else {
                if (letterOfCredit.getCurrencyCode() == null || letterOfCredit.getCurrencyCode().isEmpty() ||
                        letterOfCredit.getDocumentsRequired() == null || letterOfCredit.getTransferable() == null) {
                    newStatus = TransactionStatus.RETURNED_FOR_REVIEW;
                    if (letterOfCredit.getCurrencyCode() == null || letterOfCredit.getCurrencyCode().isEmpty()) {
                        fieldsToModify.add("Currency Code");
                    }
                    if (letterOfCredit.getDocumentsRequired() == null) {
                        fieldsToModify.add("Documents Required");
                    }
                    if (letterOfCredit.getTransferable() == null) {
                        fieldsToModify.add("Transferable");
                    }
                } else {
                    newStatus = TransactionStatus.REJECTED;
                }
            }

            letterOfCredit.setStatus(newStatus);
            letterOfCreditRepository.save(letterOfCredit);

            String responseMessage;
            if (newStatus == TransactionStatus.APPROVED) {
                responseMessage = "Letter of Credit with number " + lcNumber + " has been approved successfully";
            } else if (newStatus == TransactionStatus.RETURNED_FOR_REVIEW) {
                responseMessage = "Letter of Credit with number " + lcNumber + " has been returned for review. Please modify the following fields: " + String.join(", ", fieldsToModify);
            } else if (newStatus == TransactionStatus.REJECTED) {
                responseMessage = "Letter of Credit with number " + lcNumber + " has been rejected due to missing or incorrect information";
            } else {
                responseMessage = "Invalid status provided for the Letter of Credit";
            }

            return new ApiResponse<>(responseMessage, null, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("Letter of Credit with number " + lcNumber + " not found", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ApiResponse<String> approveLetterOfCreditByStatus(String lcNumber, String status) {
        Optional<LetterOfCredit> optionalLetterOfCredit = letterOfCreditRepository.findByLcNumber(lcNumber);

        if (optionalLetterOfCredit.isPresent()) {
            LetterOfCredit letterOfCredit = optionalLetterOfCredit.get();

            if (letterOfCredit.getStatus().equals(status)) {
                // Additional validation can be performed here before approving the Letter of Credit
                // For example, check if the amount is within a certain range

                // Update the status of the Letter of Credit to APPROVED
                letterOfCredit.setStatus(TransactionStatus.APPROVED);
                letterOfCreditRepository.save(letterOfCredit);

                return new ApiResponse<>("Letter of Credit with number " + lcNumber + " has been approved successfully", null, HttpStatus.OK.value());
            } else {
                return new ApiResponse<>("Letter of Credit with number " + lcNumber + " is not in the specified status for approval", null, HttpStatus.BAD_REQUEST.value());
            }
        } else {
            return new ApiResponse<>("Letter of Credit with number " + lcNumber + " not found", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ApiResponse<TransactionStatus> getLetterOfCreditStatusByLcNumber(String lcNumber) {
        Optional<LetterOfCredit> letterOfCreditOptional = letterOfCreditRepository.findByLcNumber(lcNumber);

        if (letterOfCreditOptional.isPresent()) {
            LetterOfCredit letterOfCredit = letterOfCreditOptional.get();

            TransactionStatus status = letterOfCredit.getStatus();

            return new ApiResponse<>("success", status, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ApiResponse<List<LetterOfCredit>> findByStatus(String status) {
        List<LetterOfCredit> letterOfCredits = letterOfCreditRepository.findByStatus(TransactionStatus.APPROVED);

        if (!letterOfCredits.isEmpty()) {
            return new ApiResponse<>("success", letterOfCredits, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ApiResponse<List<LetterOfCredit>> approveLetterOfCreditByStatus(String status) {
        List<LetterOfCredit> letterOfCredits = letterOfCreditRepository.findByStatus(TransactionStatus.PENDING_APPROVAL);

        if (!letterOfCredits.isEmpty()) {
            for (LetterOfCredit letterOfCredit : letterOfCredits) {
                // Perform approval logic here

                // Assuming approval logic was successful
                letterOfCredit.setStatus(TransactionStatus.APPROVED);
                letterOfCreditRepository.save(letterOfCredit);
            }

            return new ApiResponse<>("success", letterOfCredits, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ApiResponse<String> deleteLetterOfCreditByLcNumber(String lcNumber) {
        Optional<LetterOfCredit> letterOfCreditOptional = letterOfCreditRepository.findByLcNumber(lcNumber);

        if (letterOfCreditOptional.isPresent()) {
            LetterOfCredit letterOfCredit = letterOfCreditOptional.get();

            letterOfCreditRepository.delete(letterOfCredit);

            return new ApiResponse<>("success", "Letter of Credit with LC number " + lcNumber + " has been deleted", HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", "Letter of Credit with LC number " + lcNumber + " not found", HttpStatus.NOT_FOUND.value());
        }
    }
    @Override
    public ApiResponse<String> softDeleteLetterOfCreditByLcNumber(String lcNumber) {
        Optional<LetterOfCredit> letterOfCreditOptional = letterOfCreditRepository.findByLcNumber(lcNumber);

        if (letterOfCreditOptional.isPresent()) {
            LetterOfCredit letterOfCredit = letterOfCreditOptional.get();
            letterOfCredit.setIsDeleted(true);

            letterOfCreditRepository.save(letterOfCredit);

            return new ApiResponse<>("success", "Letter of Credit with LC number " + lcNumber + " has been deleted", HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("error", "Letter of Credit with LC number " + lcNumber + " not found", HttpStatus.NOT_FOUND.value());
        }
    }
    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public ApiResponse<List<LetterOfCredit>> getAllApprovedTransactions() {
        List<LetterOfCredit> transactions = letterOfCreditRepository.findByStatus(TransactionStatus.APPROVED);
        if (!transactions.isEmpty()) {
            return new ApiResponse<>("The following are the approved Tickets ", transactions, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("There are no Approved Tickets at the moment", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public ApiResponse<List<LetterOfCredit>> getAllRejectedTransactions() {
        List<LetterOfCredit> transactions = letterOfCreditRepository.findByStatus(TransactionStatus.REJECTED);
        if (!transactions.isEmpty()) {
            return new ApiResponse<>("The following are the rejected Tickets", transactions, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("There are no Rejected Tickets at the moment", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public ApiResponse<List<LetterOfCredit>> getAllReturnedForReviewTransactions() {
        List<LetterOfCredit> transactions = letterOfCreditRepository.findByStatus(TransactionStatus.RETURNED_FOR_REVIEW);
        if (!transactions.isEmpty()) {
            return new ApiResponse<>("The following are the Returned for Review Tickets", transactions, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("There are No Tickets That have been Returned For Review", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    @org.springframework.transaction.annotation.Transactional(readOnly = true)
    public ApiResponse<List<LetterOfCredit>> getAllReturnedForApprovalTransactions() {
        List<LetterOfCredit> transactions = letterOfCreditRepository.findByStatus(TransactionStatus.RETURNED_FOR_APPROVAL);
        if (!transactions.isEmpty()) {
            return new ApiResponse<>("The following are the Returned for Approval Tickets", transactions, HttpStatus.OK.value());
        } else {
            return new ApiResponse<>("There are No Tickets That have been Returned For Approval", null, HttpStatus.NOT_FOUND.value());
        }
    }

    @Override
    public ApiResponse<LetterOfCreditRequest> getAllLetterOfCreditRequests() {
        return null;
    }
//    @Override
//    public ApiResponse<LetterOfCreditRequest> getAllLetterOfCreditRequests() {
//        List<LetterOfCreditRequest> letterOfCreditRequests = letterOfCreditRepository.findAll();
//        List<LetterOfCreditRequest> enrichedLetterOfCreditRequests = new ArrayList<>();
//
//        for (LetterOfCreditRequest request : letterOfCreditRequests) {
//            LetterOfCreditRequest enrichedRequest = enrichWithApplicantAndBeneficiary(request);
//            enrichedLetterOfCreditRequests.add(enrichedRequest);
//        }
//
//        return new ApiResponse<>(enrichedLetterOfCreditRequests, HttpStatus.OK);
//    }
//
//    private LetterOfCreditRequest enrichWithApplicantAndBeneficiary(LetterOfCreditRequest request) {
//        // Fetch applicant details
//        ApplicantDto applicantDto = accountClientService.getApplicantDetails(request.getNationalId());
//        // Fetch beneficiary details
//        BeneficiaryDto beneficiaryDto = accountClientService.getBeneficiaryDetails(request.getBeneficiaryDto());
//
//        // Enrich the original request with the fetched details
//        return request.builder()
//                .applicantDto(applicantDto)
//                .beneficiaryDto(beneficiaryDto)
//                .build();
//    }
//}


//    @Override
//    public ApiResponse<String> getByLcNumber1(String lcNumber) {
//        Optional<LetterOfCredit> letterOfCreditOptional = letterOfCreditRepository.findByLcNumber(lcNumber);
//        if (letterOfCreditOptional.isPresent()) {
//            LetterOfCredit letterOfCredit = letterOfCreditOptional.get();
//            String cifId = letterOfCredit.getCifId();
//
//            // Fetch applicant details asynchronously
//            CompletableFuture<ResponseEntity<ApiResponse<List<ApplicantDto>>>> applicantFuture =
//                    accountClientService.getAccountDetailsByCifIdAsync(cifId);
//
//            // Fetch beneficiary details asynchronously
//            // Assuming you have a way to obtain the necessary parameters for getBeneficiaryDetailsAsync
//            CompletableFuture<BeneficiaryDto> beneficiaryFuture =
//                    accountClientService.getBeneficiaryDetailsAsync(/* Pass necessary parameters here */);
//
//            // Wait for both futures to complete
//            try {
//                ResponseEntity<ApiResponse<List<ApplicantDto>>> applicantResponse = applicantFuture.join();
//                BeneficiaryDto beneficiaryDto = beneficiaryFuture.join();
//
//                // Assuming you have a method to create a LetterOfCreditRequest with the fetched data
//                LetterOfCreditRequest letterOfCreditRequest = createLetterOfCreditRequest(letterOfCredit, applicantResponse, beneficiaryDto);
//
//                // Proceed with your business logic using the populated LetterOfCreditRequest
//                // For demonstration, just returning success response
//                return new ApiResponse<>("success", null, HttpStatus.OK.value());
//            } catch (CompletionException e) {
//                // Handle exceptions thrown by join()
//                return new ApiResponse<>("error", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
//            }
//        } else {
//            return new ApiResponse<>("error", "Letter of Credit not found", HttpStatus.NOT_FOUND.value());
//        }
//    }
//
//    private LetterOfCreditRequest createLetterOfCreditRequest(LetterOfCredit letterOfCredit, ResponseEntity<ApiResponse<List<ApplicantDto>>> applicantResponse, BeneficiaryDto beneficiaryDto) {
//        // Implement logic to create LetterOfCreditRequest using the provided data
//        // This is a placeholder implementation
//        return new LetterOfCreditRequest(
//                letterOfCredit, // Original LetterOfCredit data
//                applicantResponse.getBody().getData(), // Fetched applicant details
//                beneficiaryDto // Fetched beneficiary details
//        );
//    }


}


