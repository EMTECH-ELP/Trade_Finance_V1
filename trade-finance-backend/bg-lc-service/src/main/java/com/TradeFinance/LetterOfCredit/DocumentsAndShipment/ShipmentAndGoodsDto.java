package com.TradeFinance.LetterOfCredit.DocumentsAndShipment;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class ShipmentAndGoodsDto {
    private Date shipmentDate;
    private String portOfDischarge;
    private String portOfLoading;
    private String shipmentTerms;
    private String partialShipment;
    private String transShipment;
    private String commodityCode;
    private Integer goodsQuantity;
    private BigDecimal pricePerUnit;
    private String countryOfOrigin;
}
