package acc.accountservice.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BankStatementDto {
    private String transactionType;
    private BigDecimal amount;
    private String accountNumber;
    private String status;
}
