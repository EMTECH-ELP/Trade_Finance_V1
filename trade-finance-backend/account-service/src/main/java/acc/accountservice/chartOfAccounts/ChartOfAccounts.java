package acc.accountservice.chartOfAccounts;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ChartOfAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long officeAccountId;
    private String accountType; // Can be Asset, Liability, Equity, Income, or Expense
    private String accountName;
    private Double balance;
    private String description;
}
