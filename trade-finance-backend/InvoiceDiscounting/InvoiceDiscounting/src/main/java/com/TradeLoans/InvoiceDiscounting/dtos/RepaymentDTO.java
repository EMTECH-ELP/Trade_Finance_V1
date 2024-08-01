package com.TradeLoans.InvoiceDiscounting.dtos;


import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@Builder
public class RepaymentDTO {

    private Long repaymentId;
    private Long invoiceId;
    private Long debtorNameId;
    private BigDecimal originalAmount;
    private BigDecimal repaymentAmount;
    private BigDecimal outstandingAmount;
    private Date repaymentDate;
    private Date actualRepaymentDate;
    private String status;
    private BigDecimal penaltyAmount;
}