package acc.accountservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AccountInfo {
    @Schema(
            name = " AccountName"
    )
    private String accountName;
    @Schema(
            name = " AccountNumber"
    )
    private String accountNumber;
    @Schema(
            name = " AccountBalance"
    )
    private BigDecimal accountBalance;

}
