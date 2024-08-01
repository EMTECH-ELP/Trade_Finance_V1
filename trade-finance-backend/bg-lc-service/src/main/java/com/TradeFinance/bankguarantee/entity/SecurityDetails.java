package com.TradeFinance.bankguarantee.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
@Table(name = "Security_details")
public class SecurityDetails extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long collateralId;
    @Column(name = "applicant_id")
    //private Long applicantId;
    private String securityType;
    private BigDecimal securityAmount;
    private String securityCurrency;
    private String securityChargeAccount;
    private String description;
    private String issuer;
    private String maturityDate;
    private String securityRating;

    @OneToOne(mappedBy = "securityDetails")
    @JsonBackReference
    private BankGuarantee bankGuarantee;


}
