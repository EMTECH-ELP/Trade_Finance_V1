package com.trade.authservice.tradeFinance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor

public class DCCreationRequest {
    private String dcNumber;
    private String remittingBank;
    private double amount;
    // Other fields, getters, and setters
}
