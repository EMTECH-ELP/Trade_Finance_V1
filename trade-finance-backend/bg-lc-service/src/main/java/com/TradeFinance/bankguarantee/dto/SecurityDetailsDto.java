package com.TradeFinance.bankguarantee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class SecurityDetailsDto {
//    @Schema(description = "The unique identifier of the applicant", example = "123456789")
//    private Long applicantId;
    @Schema(description = "Type of security detail", example = "Stock")
    private String securityType;
    @Schema(description = "Amount of the security", example = "1000.00")
    private BigDecimal securityAmount;
    @Schema(description = "Currency of the amount", example = "USD")
    private String securityCurrency;
    @Schema(description = "Charge account", example = "1234567890")
    private String securityChargeAccount;
    @Schema(description = "Description of the security", example = "Apple Inc. stock")
    private String description;
    @Schema(description = "Issuer of the security", example = "Apple Inc.")
    private String issuer;
    @Schema(description = "Maturity date of the security", example = "2023-12-31")
    private String maturityDate;
    @Schema(description = "Rating of the security", example = "A")
    private String securityRating;
}
