package acc.accountservice.applicant;

import com.TradeFinance.accountservice.account.Account;
import com.TradeFinance.accountservice.account.AccountProjection;
import com.TradeFinance.accountservice.account.AccountRepository;
import com.TradeFinance.accountservice.account.AccountServiceImpl;
import com.TradeFinance.accountservice.applicant.ApplicantRepository;
import com.TradeFinance.accountservice.applicant.impl.ApplicantService;
import com.TradeFinance.accountservice.dto.*;
import com.TradeFinance.accountservice.emailAlerts.impl.EmailService;
;
import com.TradeFinance.accountservice.util.AccountUtils;
import com.TradeFinance.accountservice.util.ApiResponse;
import com.itextpdf.text.log.Logger;
import com.itextpdf.text.log.LoggerFactory;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.time.LocalDateTime;
import java.util.Collections;
import java.util.List;


@Service
@AllArgsConstructor
public class ApplicantServiceImpl implements ApplicantService {
    @Autowired
    AccountRepository accountRepository;
    @Autowired
    ApplicantRepository applicantRepository;
        @Autowired
        EmailService emailService;
    @Autowired
    com.TradeFinance.accountservice.transaction.impl.transactionService transactionService;
    private static final Logger logger = LoggerFactory.getLogger(AccountServiceImpl.class);


    @Override
    public BankResponse createAccount(ApplicantDto applicantDto) {
        /**
         * Creating an account - saving a new applicant into the db
         * Check if user already has an account
         */
        if (applicantRepository.existsByEmail(applicantDto.getEmail())) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_EXISTS_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_EXISTS_MESSAGE)
                    .accountInfo(null)
                    .build();
        }
        Applicant newApplicant = Applicant.builder()
                .accountName(applicantDto.getAccountName())
//                .nationalId(applicantDto.getNationalId())
                .address(applicantDto.getAddress())
                .postalCode(applicantDto.getPostalCode())
                .city(applicantDto.getCity())
//                .formattedAddress(applicantDto.getFormattedAddress())
                .currency(applicantDto.getCurrency())
                .email(applicantDto.getEmail())
                .phoneNumber(applicantDto.getPhoneNumber())
//                .alternativePhoneNumber(applicantDto.getAlternativePhoneNumber())
                .countryCode(applicantDto.getCountryCode())
                .country(applicantDto.getCountry())
                .cifId(AccountUtils.generateCifId())
                .accountNumber(AccountUtils.generateAccountNumber())
                .accountBalance(BigDecimal.ZERO)
                .status("ACTIVE")
                .build();



        Applicant savedApplicant = applicantRepository.save(newApplicant);
        accountRepository.save(createNewAccount(savedApplicant));
        //send email alert
        EmailDto emailDto = EmailDto.builder()
                .recipient(savedApplicant.getEmail())
                .subject("ACCOUNT CREATION")
                .messageBody("Congratulations, Your account has been successfully created. \n Your Account Details: \n" +
                        "Account Name : "+ savedApplicant.getAccountName() +"\n Account Number: "+ savedApplicant.getAccountNumber())
                .build();


        emailService.sendEmailAlert(emailDto);
        return BankResponse.builder()

                .responseCode(AccountUtils.ACCOUNT_CREATION_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREATION_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountBalance(savedApplicant.getAccountBalance())
                        .accountNumber(savedApplicant.getAccountNumber())
                        .accountName(savedApplicant.getAccountName())
                        .build())
                .build();


    }

    @Override
    public BankResponse balanceEnquiry(EnquiryRequest request) {
        //check if the provided account number exists in the bd
        Boolean isAccountExist = applicantRepository.existsByAccountNumber(request.getAccountNumber());
        if (!isAccountExist) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_NOT_EXIST_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_NOT_EXIST_MESSAGE)
                    .accountInfo(null)
                    .build();
        }
            Applicant foundApplicant = applicantRepository.findByAccountNumber(request.getAccountNumber());
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_FOUND_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_FOUND_SUCCESS)
                    .accountInfo(AccountInfo.builder()
                            .accountBalance(foundApplicant.getAccountBalance())
                            .accountNumber(request.getAccountNumber())
                            .accountName(foundApplicant.getAccountName())
                            .build())
                    .build();
        }

    @Override
    public String nameEnquiry(EnquiryRequest request) {
        boolean isAccountExist = applicantRepository.existsByAccountNumber(request.getAccountNumber());
        if (!isAccountExist){
            return AccountUtils.ACCOUNT_NOT_EXIST_MESSAGE;
        }
        Applicant foundApplicant = applicantRepository.findByAccountNumber(request.getAccountNumber());
        return foundApplicant.getAccountName();
    }



    @Override
    public BankResponse creditAccount(CreditDebitRequest request) {
        //checking if the account exists
        boolean isAccountExist = applicantRepository.existsByAccountNumber(request.getAccountNumber());
        if (!isAccountExist){
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_NOT_EXIST_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_NOT_EXIST_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        Applicant applicantToCredit = applicantRepository.findByAccountNumber(request.getAccountNumber());
        applicantToCredit.setAccountBalance(applicantToCredit.getAccountBalance().add(request.getAmount()));
        applicantRepository.save(applicantToCredit);

        //save the transaction
        BankStatementDto bankStatementDto = BankStatementDto.builder()
                .accountNumber(applicantToCredit.getAccountNumber())
                .transactionType("CREDIT")
                .amount(request.getAmount())
                .build();
        transactionService.saveTransaction(bankStatementDto);

        return BankResponse.builder()
                .responseCode(AccountUtils.ACCOUNT_CREDITED_SUCCESS)
                .responseMessage(AccountUtils.ACCOUNT_CREDITED_SUCCESS_MESSAGE)
                .accountInfo(AccountInfo.builder()
                        .accountName(applicantToCredit.getAccountName())
                        .accountBalance(applicantToCredit.getAccountBalance())
                        .accountNumber(request.getAccountNumber())
                        .build())
                .build();
    }

    @Override
    public BankResponse debitAccount(CreditDebitRequest request) {
        boolean isAccountExist = applicantRepository.existsByAccountNumber(request.getAccountNumber());
        if (!isAccountExist){
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_NOT_EXIST_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_NOT_EXIST_MESSAGE)
                    .accountInfo(null)
                    .build();
        }

        Applicant applicantToDebit = applicantRepository.findByAccountNumber(request.getAccountNumber());
        BigInteger availableBalance =applicantToDebit.getAccountBalance().toBigInteger();
        BigInteger debitAmount = request.getAmount().toBigInteger();
        if ( availableBalance.intValue() < debitAmount.intValue()){
            return BankResponse.builder()
                    .responseCode(AccountUtils.INSUFFICIENT_BALANCE_CODE)
                    .responseMessage(AccountUtils.INSUFFICIENT_BALANCE_MESSAGE)
                    .accountInfo(null)
                    .build();
        }
        else {
            applicantToDebit.setAccountBalance(applicantToDebit.getAccountBalance().subtract(request.getAmount()));
            applicantRepository.save(applicantToDebit);
            BankStatementDto bankStatementDto = BankStatementDto.builder()
                    .accountNumber(applicantToDebit.getAccountNumber())
                    .transactionType("DEBIT")
                    .amount(request.getAmount())
                    .build();
            transactionService.saveTransaction(bankStatementDto);
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_DEBITED_SUCCESS)
                    .responseMessage(AccountUtils.ACCOUNT_DEBITED_MESSAGE)
                    .accountInfo(AccountInfo.builder()
                            .accountNumber(request.getAccountNumber())
                            .accountName(applicantToDebit.getAccountName())
                            .accountBalance(applicantToDebit.getAccountBalance())
                            .build())
                    .build();
        }
    }

    @Override
    public BankResponse transfer(TransferRequest request) {
        Boolean isDestinationAccountExist = applicantRepository.existsByAccountNumber(request.getDestinationAccountNumber());
        if (!isDestinationAccountExist) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.ACCOUNT_NOT_EXIST_CODE)
                    .responseMessage(AccountUtils.ACCOUNT_NOT_EXIST_MESSAGE)
                    .accountInfo(null)
                    .build();
        }
        Applicant sourceAccountApplicant = applicantRepository.findByAccountNumber(request.getSourceAccountNumber());
        if (request.getAmount().compareTo(sourceAccountApplicant.getAccountBalance()) > 0) {
            return BankResponse.builder()
                    .responseCode(AccountUtils.INSUFFICIENT_BALANCE_CODE)
                    .responseMessage(AccountUtils.INSUFFICIENT_BALANCE_MESSAGE)
                    .accountInfo(null)
                    .build();
        }
        sourceAccountApplicant.setAccountBalance(sourceAccountApplicant.getAccountBalance().subtract(request.getAmount()));
        String sourceUsername = sourceAccountApplicant.getAccountName();
        applicantRepository.save(sourceAccountApplicant);
        EmailDto debitAlert = EmailDto.builder()
                .subject("DEBIT ALERT")
                .recipient(sourceAccountApplicant.getEmail())
                .messageBody("The sum of " + request.getAmount()+ "has been deducted from your account")
                .build();
        emailService.sendEmailAlert(debitAlert);


        Applicant destinationAccountApplicant = applicantRepository.findByAccountNumber(request.getDestinationAccountNumber());
        destinationAccountApplicant.setAccountBalance(destinationAccountApplicant.getAccountBalance().add(request.getAmount()));
//        String recipientUsername = destinationAccountApplicant.getAccountName();
        applicantRepository.save(destinationAccountApplicant);
        EmailDto creditAlert = EmailDto.builder()
                .subject("CREDIT ALERT")
                .recipient(sourceAccountApplicant.getEmail())
                .messageBody("The sum of " + request.getAmount()+ "has been sent to your account from " + sourceUsername)
                .build();
        emailService.sendEmailAlert(creditAlert);
//save transaction
        BankStatementDto bankStatementDto = BankStatementDto.builder()
                .accountNumber(destinationAccountApplicant.getAccountNumber())
                .transactionType("CREDIT")
                .amount(request.getAmount())
                .build();
        transactionService.saveTransaction(bankStatementDto);

        return BankResponse.builder()
                .responseCode(AccountUtils.TRANSFER_SUCCESSFUL_CODE)
                .responseMessage(AccountUtils.TRANSFER_SUCCESSFUL_MESSAGE)
                .accountInfo(null)
                .build();

    }

    private Account createNewAccount(Applicant applicant) {
        Account newAccount = new Account();
        newAccount.setApplicantId(applicant.getApplicantId());
newAccount.setAccountNumber(Long.valueOf(applicant.getAccountNumber()));
newAccount.setCountryCode(applicant.getCountryCode());
newAccount.setAddress(applicant.getAddress());
newAccount.setCountry(applicant.getCountry());
newAccount.setNationalId(applicant.getNationalId());
newAccount.setCurrency(applicant.getCurrency());
newAccount.setPostalCode(applicant.getPostalCode());
newAccount.setEmail(applicant.getEmail());
newAccount.setPhoneNumber(applicant.getPhoneNumber());
newAccount.setAccountType(applicant.getAccountType());
newAccount.setCifId(applicant.getCifId());
newAccount.setAlternativePhoneNumber(applicant.getAlternativePhoneNumber());
newAccount.setCity(applicant.getCity());
newAccount.setStatus(applicant.getStatus());
newAccount.setAccountType(applicant.getAccountType());
newAccount.setAccountName(applicant.getAccountName());


//        newAccount.setAccountType(AccountUtils.SAVINGS);
        newAccount.setBranchAddress(AccountUtils.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("prissy");
        return newAccount;
    }

    @Transactional
    public ApiResponse<List<AccountProjection>> getAccountDetailsByCifIdOrAccountNumberOrNationalId(String cifId, String accountNumber, String nationalId) {
        try {
            List<AccountProjection> basicAccounts = accountRepository.findByCifIdOrAccountNumberOrNationalId(cifId, accountNumber, nationalId);

            if (!basicAccounts.isEmpty()) {
                // Convert basicAccounts to array if it's not empty
                AccountProjection[] accountProjectionsArray = new AccountProjection[basicAccounts.size()];
                basicAccounts.toArray(accountProjectionsArray);

                logger.info("Account details retrieved successfully");
                return new ApiResponse<>("Basic account details retrieved successfully", basicAccounts, HttpStatus.OK.value());
            } else {
                logger.info("No account found with the given cifId, advice on creating an account");
                return new ApiResponse<>("No account found with the given cifId, advice on creating an account", Collections.emptyList(), HttpStatus.NOT_FOUND.value());
            }
        } catch (Exception e) {
            // Log the error
            logger.error("An error occurred while fetching account details", e);
            // Return an error response
            return new ApiResponse<>("An error occurred while fetching account details", Collections.emptyList(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        }
    }

    @Override
    public ApiResponse<AccountProjection[]> getAccountDetailsAsArray(String cifId, String accountNumber, String nationalId) {
        AccountProjection[] accountProjectionsArray = accountRepository.findByCifIdOrAccountNumberOrNationalId(cifId, accountNumber, nationalId).toArray(new AccountProjection[0]);

        if (accountProjectionsArray != null && accountProjectionsArray.length > 0) {
            // Return ApiResponse with the array of AccountProjection objects
            return new ApiResponse<>("Basic account details retrieved successfully", accountProjectionsArray, HttpStatus.OK.value());
        } else {
            // Return ApiResponse with an empty array
            return new ApiResponse<>("No account found with the given account", new AccountProjection[0], HttpStatus.NOT_FOUND.value());
        }

    }


    }












