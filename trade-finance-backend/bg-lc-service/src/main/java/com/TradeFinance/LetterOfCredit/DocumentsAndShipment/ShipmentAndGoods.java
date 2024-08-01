package com.TradeFinance.LetterOfCredit.DocumentsAndShipment;

import com.TradeFinance.LetterOfCredit.LetterOfCredit;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;
import java.util.Set;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "shipment_tbl")
public class ShipmentAndGoods {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @JsonFormat(pattern = "dd/MM/yyyy HH:mm:ss", shape = JsonFormat.Shape.STRING, timezone = "Z")
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
    @OneToOne(mappedBy = "shipmentAndGoods")
    @JsonBackReference
    private LetterOfCredit letterOfCredit;
}
