package com.TradeLoans.InvoiceDiscounting.model;


public enum InvoiceStatus {
    CREATED, PENDING, APPROVED
}

//Now, the Invoice entity will transition from CREATED to PENDING automatically upon creation, and from PENDING to APPROVED automatically upon approval.