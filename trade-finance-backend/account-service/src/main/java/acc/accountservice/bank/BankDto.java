package acc.accountservice.bank;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankDto {
    private String bankName;
    private String branchName;
    private String branchCode;
    private String bankCountry;
    private String bankSwiftCode;

}
