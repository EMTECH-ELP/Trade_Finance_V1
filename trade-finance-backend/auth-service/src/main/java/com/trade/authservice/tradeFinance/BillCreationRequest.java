package com.trade.authservice.tradeFinance;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class BillCreationRequest {
    private String billNumber;
    private String payer;
    private double amount;
    // Other fields, getters, and setters
}
