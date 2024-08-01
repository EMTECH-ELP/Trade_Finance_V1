package com.TradeFinance.collectionservice.goodsAndShipment;

import lombok.Data;

import java.math.BigDecimal;
@Data
public class GoodDto {
    private String name;
    private String description;
    private BigDecimal value;
    private int quantity;
    private String hsCode;
}
