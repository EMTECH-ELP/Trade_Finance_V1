package acc.accountservice.chartOfAccounts;

public class AccountUpdateDto {

        private Long id;
        private String accountName;
        private String accountType; // Could be ASSET, LIABILITY, EQUITY, INCOME, EXPENSE
        private Double newBalance;

        // Default constructor
        public AccountUpdateDto() {}

        // Parameterized constructor
        public AccountUpdateDto(Long id, String accountName, String accountType, Double newBalance) {
            this.id = id;
            this.accountName = accountName;
            this.accountType = accountType;
            this.newBalance = newBalance;
        }

        // Getters and setters
        public Long getId() {
            return id;
        }

        public void setId(Long id) {
            this.id = id;
        }

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

        public Double getNewBalance() {
            return newBalance;
        }

        public void setNewBalance(Double newBalance) {
            this.newBalance = newBalance;
        }
    }


