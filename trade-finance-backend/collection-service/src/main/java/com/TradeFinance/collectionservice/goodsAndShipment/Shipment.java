package com.TradeFinance.collectionservice.goodsAndShipment;

import com.TradeFinance.collectionservice.collection.Collection;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date shipmentDate;
    private String countryOfOrigin;
    private String portOfLoading;
    private String portOfDischarge;
    private String incoTerms;
    private String incoTermsDescription;
    private String billOfLading;
    private String airWayBillNumber;
    @OneToOne(mappedBy="shipment")
    private Collection collection;

}
