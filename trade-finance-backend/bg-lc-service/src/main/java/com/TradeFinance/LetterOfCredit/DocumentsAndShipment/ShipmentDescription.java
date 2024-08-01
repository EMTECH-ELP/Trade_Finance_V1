package com.TradeFinance.LetterOfCredit.DocumentsAndShipment;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ShipmentDescription {
    private String commodityCode;
    private int goodsQuantity;
    private BigDecimal pricePerUnit;
}
