package com.TradeFinance.bankguarantee.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Date;


//@Data
@Table
@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor
public class CounterGuaranteeDetails extends BaseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long counterGuaranteeId;
    private String guaranteeNo;
    private BigDecimal counterGuaranteeAmount;
    private Date expiryDate;
    private Date claimExpiryDate;
    private String swiftCode;
    private String branchCode;
    private String remarks;
    private String counterGuaranteeStatus;
    @OneToOne(mappedBy = "counterGuaranteeDetails")
    @JsonBackReference
    private BankGuarantee bankGuarantee;

}
