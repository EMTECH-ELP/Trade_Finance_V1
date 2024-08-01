package com.trade.authservice.tradeFinance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class IDCreationRequest {
    private String idNumber;
    private String debtor;
    private double amount;
    // Other fields, getters, and setters
}
