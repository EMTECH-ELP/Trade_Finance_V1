package acc.accountservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankResponse {
    @Schema(
            name = "Bank response code"
    )
    private String responseCode;
    @Schema(
            name = "Bank response message"
    )
    private String responseMessage;
    @Schema(
            name = "Your account information"
    )
    private AccountInfo accountInfo;
}
