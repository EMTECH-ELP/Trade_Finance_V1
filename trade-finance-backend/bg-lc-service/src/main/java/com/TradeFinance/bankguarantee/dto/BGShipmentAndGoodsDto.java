package com.TradeFinance.bankguarantee.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

@Data
public class BGShipmentAndGoodsDto {

    @Schema(description = "The date of the shipment", example = "2023-04-01")
    private Date shipmentDate;

    @Schema(description = "The port where the goods are discharged", example = "New York")
    private String portOfDischarge;

    @Schema(description = "The port where the goods are loaded", example = "Los Angeles")
    private String portOfLoading;

    @Schema(description = "The terms under which the goods are shipped", example = "FOB")
    private String shipmentTerms;

    @Schema(description = "Indicates if the shipment is partial", example = "Yes")
    private String partialShipment;

    @Schema(description = "Indicates if the shipment is transshipment", example = "No")
    private String transShipment;

    @Schema(description = "The commodity code for the goods", example = "123456")
    private String commodityCode;

    @Schema(description = "The quantity of goods in the shipment", example = "100")
    private Integer goodsQuantity;

    @Schema(description = "The price per unit of the goods", example = "10.50")
    private BigDecimal pricePerUnit;

    @Schema(description = "The country of origin of the goods", example = "China")
    private String countryOfOrigin;
}

