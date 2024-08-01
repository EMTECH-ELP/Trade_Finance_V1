package acc.accountservice.chartOfAccounts;

import lombok.Data;

@Data
public class AccountSummaryDto {
        private String accountType;
        private String accountName;
        private Double balance;
        private String description;

        public AccountSummaryDto() {}

        public AccountSummaryDto(Long id, String accountType, String accountName, Double balance, String description) {
            this.accountType = accountType;
            this.accountName = accountName;
            this.balance = balance;
            this.description = description;
        }

        // Getters and Setters for each field


        public String getAccountType() {
            return accountType;
        }

        public void setAccountType(String accountType) {
            this.accountType = accountType;
        }

        public String getAccountName() {
            return accountName;
        }

        public void setAccountName(String accountName) {
            this.accountName = accountName;
        }

        public Double getBalance() {
            return balance;
        }

        public void setBalance(Double balance) {
            this.balance = balance;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
    }


