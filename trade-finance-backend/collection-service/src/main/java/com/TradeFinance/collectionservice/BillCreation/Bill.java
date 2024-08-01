package com.TradeFinance.collectionservice.BillCreation;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table (name = "billcreation")
public class Bill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long billId;
    @Column(name = "billNumber", unique = true)
    private String billNumber;
    @Column(name = "amount")
    private BigDecimal amount;
    @Column(name = "currency")
    private String currency;
    @Column(name = "issueDate")
    private Date issueDate;
    @Column(name = "dueDate")
    private Date dueDate;
    @Column(name = "applicant")
    private String applicant;
    @Column(name = "beneficiary")
    private String beneficiary;
    @Column(name = "tenor")
    private int tenor;
    @Column(name = "discountRate")
    private Double discountRate;
    @Column(name = "acceptanceDueDate")
    private Date acceptanceDueDate;
    @Column(name = "acceptanceStatus")
    private String acceptanceStatus;
    @Column(name = "negotiatedAmount")
    private Double negotiatedAmount;
    @Column(name = "negotiatedDate")
    private Date negotiationDate;
    @Column(name = "protestDate")
    private Date protestDate;
    @Column(name = "type")
    private String type;
    @Column(name = "accountId")
    private Long accountId;
    @Column(name = "document")
    private String document;
    @Column(name = "avalisationStatus")
    private boolean avalised;
    @Column(name = "avalisationExpiryDate")
    private Date avalisationExpiryDate;
    @Column(name = "guarantor")
    private String guarantor;

    public void setBillNumber(String randomBillNumber) {
        this.billNumber=billNumber;
    }

    public boolean isApproved() {
        return false;
    }

    public void setApproved(boolean b) {
    }
}
