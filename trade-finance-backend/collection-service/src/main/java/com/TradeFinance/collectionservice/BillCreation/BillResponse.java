package com.TradeFinance.collectionservice.BillCreation;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class BillResponse {
    private long billId;
    private BigDecimal amount;
    private String currency;
    private Date issueDate;
    private Date dueDate;
    private String applicant;
    private String beneficiary;

    private int tenor;

    private Double discountRate;

    private Date acceptanceDueDate;

    private String acceptanceStatus;

    private Double negotiatedAmount;

    private Date negotiationDate;

    private Date protestDate;

    private String type;
    private Long accountId;

}
