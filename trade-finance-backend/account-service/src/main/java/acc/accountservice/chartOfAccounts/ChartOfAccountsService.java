package acc.accountservice.chartOfAccounts;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChartOfAccountsService {


        private final ChartOfAccountsRepository chartOfAccountsRepository;

        // Constructor injection for dependency management
        public ChartOfAccountsService(ChartOfAccountsRepository chartOfAccountsRepository) {
            this.chartOfAccountsRepository = chartOfAccountsRepository;
        }

        // Method to add a new account
        public ChartOfAccounts addAccount(AccountCreationDto creationDTO) {
            ChartOfAccounts account = new ChartOfAccounts();
            account.setAccountName(creationDTO.getAccountName());
            account.setAccountType(creationDTO.getAccountType());
            account.setBalance(creationDTO.getInitialBalance());

            // Generate a unique ID for the account
            Long accountId = generateAccountId();
            account.setOfficeAccountId(accountId);
            // Additional setup or validation can be performed here

            return chartOfAccountsRepository.save(account);
        }
    // Placeholder for the generateAccountId method
    private Long generateAccountId() {
        // Implement your logic to generate a unique ID
        // For simplicity, this example uses UUID, but you might use a different approach
        return UUID.randomUUID().getLeastSignificantBits() & ((1L << 62) - 1);

    }

        // Method to update an existing account
        public ChartOfAccounts updateAccount(AccountUpdateDto updateDTO) {
            ChartOfAccounts account = chartOfAccountsRepository.findById(updateDTO.getId())
                    .orElseThrow(() -> new RuntimeException("Account not found"));

            account.setAccountName(updateDTO.getAccountName());
            account.setAccountType(updateDTO.getAccountType());
            account.setBalance(updateDTO.getNewBalance());

            // Additional setup or validation can be performed here

            return chartOfAccountsRepository.save(account);
        }

        // Method to fetch all accounts
        public List<ChartOfAccounts> getAllAccounts() {
            return chartOfAccountsRepository.findAll();
        }

        // Method to fetch a single account by ID
        public ChartOfAccounts getAccountById(Long id) {
            return chartOfAccountsRepository.findById(id)
                    .orElseThrow(() -> new RuntimeException("Account not found"));
        }
    }


