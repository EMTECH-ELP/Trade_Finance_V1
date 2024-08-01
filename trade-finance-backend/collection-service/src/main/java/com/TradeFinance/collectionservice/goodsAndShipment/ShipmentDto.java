package com.TradeFinance.collectionservice.goodsAndShipment;

import lombok.Data;

import java.util.Date;

@Data
public class ShipmentDto {
    private Date shipmentDate;
    private String countryOfOrigin;
    private String portOfLoading;
    private String portOfDischarge;
    private String incoTerms;
    private String incoTermsDescription;
    private String billOfLading;
    private String airWayBillNumber;
}
