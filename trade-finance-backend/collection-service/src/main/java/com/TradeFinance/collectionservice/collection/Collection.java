package com.TradeFinance.collectionservice.collection;

import com.TradeFinance.collectionservice.dto.AccountResponse;
import com.TradeFinance.collectionservice.goodsAndShipment.Good;
import com.TradeFinance.collectionservice.goodsAndShipment.Shipment;
import com.TradeFinance.collectionservice.tenor.ProtestDetails;
import com.TradeFinance.collectionservice.tenor.TenorDetails;
import com.TradeFinance.collectionservice.tracer.TracerDetails;
import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
public class Collection {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long collectionId;
        private String cifId;
        private String accountNumber;
        private String nationalId;
        private String referenceNumber;
        private String function;
        private String currencyCode;
        private String tenorType;
        private float billAmount;
        private float localCurrencyEquivalent;
        private float billOutstandingAmount;
        private float financeAmount;
        private Date protestDate;
        private Date acceptanceDate;
        private float accountBalance;
        private String collectionType; // Import or Export

       /* @ManyToOne
        private Applicant applicant; // reference to Applicant entity

        @ManyToOne
        private Beneficiary beneficiary; // reference to Beneficiary entity

        @ManyToOne
        private Bank remittingBank; // reference to Bank entity (for remitting bank)

        @ManyToOne
        private Bank collectingBank; // reference to Bank entity (for collecting bank)*/

        @OneToOne(cascade = CascadeType.ALL)
        private Good good; // List of Goods entities

        @OneToOne(cascade = CascadeType.ALL)
        private Shipment shipment; // Shipment entity
        @OneToOne(cascade = CascadeType.ALL)
        private TenorDetails tenorDetails;
        @OneToOne(cascade = CascadeType.ALL)
        private ProtestDetails protestDetails;
        @OneToOne(cascade = CascadeType.ALL)
        private TracerDetails tracerDetails;



      /*  public Collection(CollectionRequest collectionRequest) {
                this.acceptanceDate = collectionRequest.getAcceptanceDate();
                this.billAmount = collectionRequest.getBillAmount();
                this.collectionType = collectionRequest.getCollectionType();
                this.currencyCode = collectionRequest.getCurrencyCode();
                this.function = collectionRequest.getFunction();
                this.tenorType = collectionRequest.getTenorType();
                this.protestDate = collectionRequest.getProtestDate();
                this.referenceNumber = collectionRequest.getReferenceNumber();
                this.shipment=collectionRequest.getShipmentDto();
                this.goods=collectionRequest.getGoodDto();
                // Set other fields and relationships accordingly
        }*/

        
}


