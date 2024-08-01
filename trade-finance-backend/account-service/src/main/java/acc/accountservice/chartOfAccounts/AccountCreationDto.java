package acc.accountservice.chartOfAccounts;

import lombok.Data;

@Data
public class AccountCreationDto {

//        private Long Id;
        private String accountName;
        private String accountType; // Could be ASSET, LIABILITY, EQUITY, INCOME, EXPENSE
        private Double initialBalance;
        private String description;

        // Default constructor
        public AccountCreationDto() {}

        // Parameterized constructor
        public AccountCreationDto(String accountName, String accountType, Double initialBalance) {
            this.accountName = accountName;
            this.accountType = accountType;
            this.initialBalance = initialBalance;
        }

        // Getters and setters
        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public String getAccountType() {
            return accountType;
        }

        public void setAccountType(String accountType) {
            this.accountType = accountType;
        }

        public Double getInitialBalance() {
            return initialBalance;
        }

        public void setInitialBalance(Double initialBalance) {
            this.initialBalance = initialBalance;
        }
    }


