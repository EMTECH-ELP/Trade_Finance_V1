package com.TradeLoans.InvoiceDiscounting.dtos;

import com.TradeLoans.InvoiceDiscounting.model.Funding;
import lombok.*;
import com.TradeLoans.InvoiceDiscounting.model.Funding.FundingStatus;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class FundingDTO {
    private BigDecimal creditLimit;
    private BigDecimal fundingAmount;
    private BigDecimal creditAccount;
    private Date disbursalDate;
    private Date repaymentDate;
    private boolean fundingRepaymentStatus;
    private Funding.FundingStatus status;
    private BigDecimal discountRate;

}

