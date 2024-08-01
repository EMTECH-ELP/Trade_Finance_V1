package com.TradeFinance.collectionservice.dto;

import com.TradeFinance.collectionservice.goodsAndShipment.GoodDto;
import com.TradeFinance.collectionservice.goodsAndShipment.ShipmentDto;
import com.TradeFinance.collectionservice.tenor.ProtestDto;
import com.TradeFinance.collectionservice.tenor.TenorDto;
import com.TradeFinance.collectionservice.tracer.TracerDto;
import lombok.Builder;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
@Builder
public class CollectionRequest {
    private String cifId;
    private String nationalId;
    private String accountNumber;
    private AccountResponse accountResponse;
   // private ApplicantDto applicantDto;
    private BeneficiaryDto beneficiaryDto;
    private String referenceNumber;
    private String function;
    private String tenorType;
    private String currencyCode;
    private float billAmount;
    private Date protestDate;
    private Date acceptanceDate;
    private String collectionType;
    private GoodDto goodDto;
    private ShipmentDto shipmentDto;
    private TenorDto tenorDto;
    private ProtestDto protestDto;
    private TracerDto tracerDto;


}
