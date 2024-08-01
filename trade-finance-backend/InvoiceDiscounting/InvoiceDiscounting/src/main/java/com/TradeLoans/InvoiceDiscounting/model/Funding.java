package com.TradeLoans.InvoiceDiscounting.model;


import jakarta.persistence.*;
import lombok.*;
import java.math.BigDecimal;
import java.util.Date;


@Entity
@Table(name = "fundings")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Funding {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal creditLimit;
    private BigDecimal fundingAmount;
    private BigDecimal creditAccount;
    private Date disbursalDate;
    private Date repaymentDate;
    private boolean fundingRepaymentStatus;
    private BigDecimal discountRate;

    @Enumerated(EnumType.STRING)
    private FundingStatus status;

    @ManyToOne
    @JoinColumn(name = "invoice_id")
    private Invoice invoice;

    public enum FundingStatus {
        PENDING,APPROVED, FUNDED
    }
}
