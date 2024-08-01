package com.TradeFinance.bankguarantee.entity;

import com.TradeFinance.bankguarantee.utils.enums.TransactionStatus;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.Date;


@Builder
@Entity
@Getter
@Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Table(name = "bg_details_tbl")
public class BankGuarantee extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long guaranteeId;
    private String guaranteeNo;
    private String cifId;
    private String nationalId;
    private String guaranteeType;
    private String purpose;
    private String additionalInformation;
    private Long bankId;
    private BigDecimal guaranteeAmount;
    private String guaranteeCurrency;
    private BigDecimal currencyRate;
    private Date expiryDate;
    private Integer validityPeriod;// After expiry period
    private Integer maxClaimPeriod;
    private String applicableRules;
    private String counterGuaranteeStatus;
    private String guaranteeStatus;
    private String chargesBorneBy;
    private BigDecimal provisionAmount;
    //MARGIN DETAILS

    private String marginType;
    private Long marginAccount;
    private BigDecimal marginAmount;
    private BigDecimal marginRate;
    private BigDecimal collectedMarginAmount;
    private BigDecimal releasedMarginAmount;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;

    @OneToOne
    @JsonManagedReference
    private BGDocumentsRequired documentsRequiredBG;
    @OneToOne
    @JsonManagedReference
    private BGShipmentAndGoods shipmentAndGoodsBG;
    @OneToOne
    @JsonManagedReference
    private CounterGuaranteeDetails counterGuaranteeDetails;
    @OneToOne
    @JsonManagedReference
    private SecurityDetails securityDetails;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    @JsonManagedReference
    private BGApplicant applicant;

}
