package com.TradeFinance.bankguarantee.dto;


import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;

@Data
public class CounterGuaranteeDto {

    @Schema(description = "The unique identifier of the counter guarantee", example = "CG123456789")
    @NotNull
    private String guaranteeNo;

    @Schema(description = "The amount of the counter guarantee", example = "5000.00")
    private BigDecimal counterGuaranteeAmount;

    @Schema(description = "The expiry date of the counter guarantee", example = "2023-12-31")
    private Date expiryDate;

    @Schema(description = "The claim expiry date of the counter guarantee", example = "2023-12-31")
    private Date claimExpiryDate;

    @Schema(description = "The SWIFT code of the bank issuing the counter guarantee", example = "ABCDUS33")
    private String swiftCode;

    @Schema(description = "The branch code of the bank issuing the counter guarantee", example = "123456")
    private String branchCode;

    @Schema(description = "Remarks or additional information about the counter guarantee", example = "Additional details here")
    private String remarks;

    @Schema(description = "The status of the counter guarantee", example = "Active")
    private String counterGuaranteeStatus;
}
