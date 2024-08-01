package com.TradeFinance.dto;

import com.TradeFinance.LetterOfCredit.DocumentsAndShipment.DocumentsRequiredDto;
import com.TradeFinance.LetterOfCredit.DocumentsAndShipment.ShipmentAndGoodsDto;
import com.TradeFinance.LetterOfCredit.LetterOfCredit;
import com.TradeFinance.LetterOfCredit.TransactionStatus;
import com.TradeFinance.LetterOfCredit.collateral.PaymentSecurityDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.CascadeType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.OneToOne;
import lombok.*;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Data
@Builder
@Component
@AllArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class LetterOfCreditRequest {
    private String cifId;
    private String nationalId;
    private String accountNumber;
@JsonProperty("accountResponse")
    private AccountResponse accountResponse;
    private ApplicantDto applicantDto;
   @JsonProperty("beneficiaryDto")
    private BeneficiaryDto beneficiaryDto;
 @JsonProperty("secondaryBeneficiaryDto")
    private SecondaryBeneficiaryDto secondaryBeneficiaryDto;
    private String lcNumber;
    private String lcType;
    private String applicableRules;
    private Date issueDate;
    private Date expiryDate;
    private String tenor;
    private Boolean transferable;
    private Long negotiationPeriod;
    private String chargesBorneBy;
    private BigDecimal transferAmount;
    private BigDecimal amount;
    private String transferCurrencyCode;
    private String currencyCode;
    private Date newExpiryDate;
    private Date creationDate;
    private String createdBy;
    private String approvedBy;
    private Date approvalDate;
    private String confirm;
    private String advise;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
    private DocumentsRequiredDto documentsRequiredDto;
    private ShipmentAndGoodsDto shipmentAndGoodsDto;
    private PaymentSecurityDto paymentSecurityDto;

 public LetterOfCreditRequest() {
 }

    public LetterOfCreditRequest(LetterOfCredit letterOfCredit, List<ApplicantDto> data, BeneficiaryDto beneficiaryDto) {
    }
}
