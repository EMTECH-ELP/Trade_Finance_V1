package com.trade.authservice.tradeFinance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BGCreationRequest {
    private String bgNumber;
    private String beneficiary;
    private double amount;
    // Other fields, getters, and setters
}
