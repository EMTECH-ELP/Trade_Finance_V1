package com.TradeFinance.bankguarantee.dto;

import com.TradeFinance.dto.AccountResponse;
import com.TradeFinance.dto.BeneficiaryDto;
import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


@Data
@Builder
@Schema(
        name = "Bank Guarantee",
        description = "Schema to hold Bank Guarantee details"
)
@AllArgsConstructor
@NoArgsConstructor
public class BankGuaranteeRequest {
    @Schema(description = "Client Identification Number")
    private String cifId;
    @Schema(description = "National Identification Number")
    //@NotNull(message = "Guarantee type is required")
    private String nationalId;
    @Schema(description = "Account Number", example = "777617701200106")
    private String accountNumber;
    private AccountResponse accountResponse;
    private BeneficiaryDto beneficiaryDto;

//    @Schema(description = "Guarantee Number", example = "GUAR12345")
//    @NotEmpty(message = "Guarantee number is required")
//    private String guaranteeNo;

    @Schema(description = "Guarantee Number")
    private String guaranteeNo;
    @Schema(description = "Type of Guarantee", example = "FINANCIAL_GUARANTEE")
    @NotNull(message = "Guarantee type is required")
    private String guaranteeType;

    @Schema(description = "Purpose of the Guarantee", example = "Purpose of the guarantee")
    @NotEmpty(message = "Purpose is required")
    private String purpose;

    @Schema(description = "Additional Information", example = "Additional information")
    private String additionalInformation;

    @Schema(description = "Bank Identifier", example = "67890")
    private Long bankId;

    @Schema(description = "Guarantee Amount", example = "10000.00")
    @NotNull(message = "Guarantee amount is required")
    private BigDecimal guaranteeAmount;

    @Schema(description = "Currency", example = "USD")
    @NotNull(message = "Currency is required")

    private String guaranteeCurrency;

    @Schema(description = "Currency Rate", example = "150.0")
    private BigDecimal currencyRate;

    @Schema(description = "Expiry Date of the Guarantee", example = "2023-12-31")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
    //@DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date expiryDate;

    @Schema(description = "Validity Period in Days", example = "30")
    private Integer validityPeriod;

    @Schema(description = "Maximum Claim Period in Days", example = "60")
    private Integer maxClaimPeriod;

    @Schema(description = "Applicable Rules", example = "URDG" )
    private String applicableRules;

    @Schema(description = "Counter Guarantee Status", example = "YES")
    private String counterGuaranteeStatus;

//    @Schema(description = "Guarantee Status", example = "ISSUED_BUT_NOT_EFFECTIVE")
//    private GuaranteeStatus guaranteeStatus;

    @Schema(description = "Charges Borne By", example = "BOTH")
    private String chargesBorneBy;

    @Schema(description = "Provision Amount", example = "500.00")
    private BigDecimal provisionAmount;

    private CounterGuaranteeDto counterGuaranteeDto;


////MARGIN DETAILS
    @Schema(description = "Margin Type", example = "CASH")
    private String marginType;

    @Schema(description = "Margin Account Id", example = "111222")
    private Long marginAccount;

    @Schema(description = "Margin Rate", example = "0.1")
    private BigDecimal marginRate;

    @Schema(description = "Margin Amount", example = "2000.00")
    private BigDecimal marginAmount;

    @Schema(description = "Collected Margin Amount", example = "1500.00")
    private BigDecimal collectedMarginAmount;

    @Schema(description = "Released Margin Amount", example = "500.00")
    private BigDecimal releasedMarginAmount;

//    @Schema(description = "Transaction Status", example = "STATUS_C")
//    private TransactionStatus status;

    //@Schema(description = "Account Response Details")
    //private AccountResponse accountResponse;

    //@Schema(description = "BGApplicant Details")
    //private ApplicantDto applicantDto;

    //@Schema(description = "Beneficiary Details")
    private SecurityDetailsDto securityDetailsDto;
    private BGShipmentAndGoodsDto shipmentAndGoodsDto;
    private BGDocumentsRequiredDto documentsRequiredDto;

}


