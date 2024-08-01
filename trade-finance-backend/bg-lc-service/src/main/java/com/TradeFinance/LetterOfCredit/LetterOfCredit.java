package com.TradeFinance.LetterOfCredit;

import com.TradeFinance.LetterOfCredit.DocumentsAndShipment.DocumentsRequired;
import com.TradeFinance.LetterOfCredit.DocumentsAndShipment.ShipmentAndGoods;
//import com.TradeFinance.LetterOfCredit.beneficiary.Beneficiary;
import com.TradeFinance.LetterOfCredit.applicant.Applicant;
import com.TradeFinance.LetterOfCredit.beneficiary.Beneficiary;
import com.TradeFinance.LetterOfCredit.collateral.PaymentSecurity;
//import com.TradeFinance.LetterOfCredit.applicant.BGApplicant;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Builder
@Table(name = "lc_details_tbl")
public class LetterOfCredit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long letterOfCreditId;
    private String cifId;
    private String accountNumber;
    private String nationalId;
    private String lcNumber;
    private String lcType;
    private String applicableRules;
    private Date issueDate;
    private Date expiryDate;
    private String tenor;
    private Boolean transferable;
    private String transferCurrencyCode;
    private Date newExpiryDate;
    private Long negotiationPeriod;
    private String chargesBorneBy;
    private BigDecimal transferAmount;
    private BigDecimal amount;
    private String currencyCode;
    private Date creationDate;
    private String createdBy;
    private String approvedBy;
    private Date approvalDate;
    private String confirm;
    private String advise;
    private Boolean isDeleted;
    @Enumerated(EnumType.STRING)
    private TransactionStatus status;
    @OneToOne
    @JoinColumn(name = "documents_required_id", referencedColumnName = "id")
    @JsonManagedReference
    private DocumentsRequired documentsRequired;
    @OneToOne
    @JoinColumn(name = "shipment_and_goods_id", referencedColumnName = "id")
    @JsonManagedReference
    private ShipmentAndGoods shipmentAndGoods;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "payment_security_id", referencedColumnName = "id")
    @JsonManagedReference
    private PaymentSecurity paymentSecurity;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "applicant_id", referencedColumnName = "id")
    @JsonManagedReference
    private Applicant applicant;
    @OneToOne(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "beneficiary_id", referencedColumnName = "id")
    @JsonManagedReference
    private Beneficiary beneficiary;

    // Constructors, getters, and setters
}
