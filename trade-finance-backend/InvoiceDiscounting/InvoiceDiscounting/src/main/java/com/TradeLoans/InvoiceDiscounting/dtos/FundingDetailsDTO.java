package com.TradeLoans.InvoiceDiscounting.dtos;

import com.TradeLoans.InvoiceDiscounting.model.Invoice;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FundingDetailsDTO {
    private Invoice invoice;
    private FundingDTO funding;
}