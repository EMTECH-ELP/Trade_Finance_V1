package acc.accountservice.account;

import com.TradeFinance.accountservice.account.impl.AccountService;
import com.TradeFinance.accountservice.applicant.Applicant;
import com.TradeFinance.accountservice.applicant.ApplicantRepository;
import com.TradeFinance.accountservice.dto.ApplicantDto;
import com.TradeFinance.accountservice.dto.BankResponse;
import com.TradeFinance.accountservice.dto.CreditDebitRequest;
import com.TradeFinance.accountservice.dto.EnquiryRequest;
import com.TradeFinance.accountservice.exception.CustomerAlreadyExistsException;
import com.TradeFinance.accountservice.mapper.ApplicantMapper;
import com.TradeFinance.accountservice.util.AccountUtils;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Optional;
import java.util.Random;

@Service
@AllArgsConstructor
public class AccountServiceImpl implements AccountService {
    private AccountRepository accountRepository;
    private ApplicantRepository applicantRepository;
//    @Override
    public void createAccount(ApplicantDto applicantDto) throws CustomerAlreadyExistsException {
        Applicant applicant = ApplicantMapper.mapToApplicant(applicantDto, new Applicant());
        Optional<Applicant> optionalApplicant = Optional.ofNullable(applicantRepository.findByAccountNumber(applicantDto.getAccountNumber()));
        if(optionalApplicant.isPresent()) {
            throw new CustomerAlreadyExistsException("Customer already registered with given NationalIdNumber "
                    + applicantDto.getAccountNumber());
        }
        applicant.setCreatedAt(LocalDateTime.now());
        applicant.setCreatedBy("prissy");
        Applicant savedApplicant = applicantRepository.save(applicant);
        accountRepository.save(createNewAccount(savedApplicant));
    }

    @Override
    public BankResponse balanceEnquiry(EnquiryRequest request) {
        return null;
    }

    @Override
    public String nameEnquiry(EnquiryRequest request) {
        return null;
    }

    @Override
    public BankResponse creditAccount(CreditDebitRequest request) {
        return null;
    }

    /**
     * @param applicant - Customer Object
     * @return the new account details
     */
    private Account createNewAccount(Applicant applicant) {
        Account newAccount = new Account();
        newAccount.setApplicantId(applicant.getApplicantId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountUtils.SAVINGS);
        newAccount.setBranchAddress(AccountUtils.ADDRESS);
        newAccount.setCreatedAt(LocalDateTime.now());
        newAccount.setCreatedBy("prissy");
        return newAccount;
    }
    }

