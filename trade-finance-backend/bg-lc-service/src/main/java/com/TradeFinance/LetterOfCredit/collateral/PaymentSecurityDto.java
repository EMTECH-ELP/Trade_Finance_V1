package com.TradeFinance.LetterOfCredit.collateral;

import lombok.Data;

@Data
public class PaymentSecurityDto {
    private double collateralValue;
    private String collateralType;
    private String guarantorName;
    private String guarantorAddress;
    private String guarantorEmail;
    private String guarantorPhoneNumber;
}
