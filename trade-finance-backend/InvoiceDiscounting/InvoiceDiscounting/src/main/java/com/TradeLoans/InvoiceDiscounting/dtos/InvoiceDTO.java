package com.TradeLoans.InvoiceDiscounting.dtos;

import com.TradeLoans.InvoiceDiscounting.model.InvoiceStatus;
import lombok.*;


import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class InvoiceDTO {
    private String invoiceNumber;

    private Date invoiceDate;

    private BigDecimal invoiceAmount;


    private Date dueDate;

    private String applicantBusinessAddress;
    private String applicantBusinessName;
    private String termsAndCondition;
    private String buyerName;
    private String buyerBusinessName;
    private String buyerCity;
    private String buyerCountry;
    private String buyerEmailAddress;
    private InvoiceStatus status;
}
