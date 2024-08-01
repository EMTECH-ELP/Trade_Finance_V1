package com.trade.authservice.tradeFinance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class LCCreationRequest {
    private String lcNumber;
    private String beneficiary;
    private double amount;
    // Other fields, getters, and setters
}
