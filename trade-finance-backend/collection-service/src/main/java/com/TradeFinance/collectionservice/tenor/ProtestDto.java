package com.TradeFinance.collectionservice.tenor;

import lombok.Data;

@Data
public class ProtestDto {
    private String protestDate;
    private String reason;
    private String remarks;
}
