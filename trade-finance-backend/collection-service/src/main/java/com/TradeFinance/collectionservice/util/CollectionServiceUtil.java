package com.TradeFinance.collectionservice.util;

import com.TradeFinance.collectionservice.goodsAndShipment.Good;
import com.TradeFinance.collectionservice.goodsAndShipment.GoodDto;
import com.TradeFinance.collectionservice.goodsAndShipment.Shipment;
import com.TradeFinance.collectionservice.goodsAndShipment.ShipmentDto;
import com.TradeFinance.collectionservice.tenor.ProtestDetails;
import com.TradeFinance.collectionservice.tenor.ProtestDto;
import com.TradeFinance.collectionservice.tenor.TenorDetails;
import com.TradeFinance.collectionservice.tenor.TenorDto;
import com.TradeFinance.collectionservice.tracer.TracerDetails;
import com.TradeFinance.collectionservice.tracer.TracerDto;

public class CollectionServiceUtil {
    public static Good mapToGood(GoodDto goodDto){
        Good good=new Good();
        good.setName(goodDto.getName());
        good.setDescription(goodDto.getDescription());
        good.setQuantity(goodDto.getQuantity());
        good.setValue(goodDto.getValue());
        good.setHsCode(goodDto.getHsCode());
        return good;
    }
    public static Shipment mapToShipment(ShipmentDto shipmentDto){
        Shipment shipment= new Shipment();
        shipment.setShipmentDate(shipmentDto.getShipmentDate());
        shipment.setAirWayBillNumber(shipmentDto.getAirWayBillNumber());
        shipment.setBillOfLading(shipmentDto.getBillOfLading());
        shipment.setPortOfDischarge(shipmentDto.getPortOfDischarge());
        shipment.setIncoTerms(shipmentDto.getIncoTerms());
        shipment.setIncoTermsDescription(shipmentDto.getIncoTermsDescription());
        shipment.setCountryOfOrigin(shipmentDto.getCountryOfOrigin());
        shipment.setPortOfLoading(shipmentDto.getPortOfLoading());
        return shipment;
    }
    public static TenorDetails mapToTenorDetails(TenorDto tenorDto){
        TenorDetails tenorDetails=new TenorDetails();
        tenorDetails.setTenor(tenorDto.getTenor());
        tenorDetails.setTenorType(tenorDto.getTenorType());
        tenorDetails.setTenorDescription(tenorDto.getTenorDescription());
        tenorDetails.setBillAmount(tenorDto.getBillAmount());
        tenorDetails.setLodgeDate(tenorDto.getLodgeDate());
        tenorDetails.setDueDate(tenorDto.getDueDate());
        tenorDetails.setAcceptanceDate(tenorDto.getAcceptanceDate());
        return tenorDetails;
    }
    public static ProtestDetails mapToProtestDetails(ProtestDto protestDto){
        ProtestDetails protestDetails=new ProtestDetails();
        protestDetails.setProtestDate(protestDto.getProtestDate());
        protestDetails.setReason(protestDto.getReason());
        protestDetails.setRemarks(protestDto.getRemarks());
        return protestDetails;
    }
    public static TracerDetails mapToTracerDetails(TracerDto tracerDto){
        TracerDetails tracerDetails=new TracerDetails();
        tracerDetails.setTracerFrequency(tracerDto.getTracerFrequency());
        tracerDetails.setTracerMedium(tracerDto.getTracerMedium());
        tracerDetails.setTracerStatus(tracerDto.getTracerStatus());
        tracerDetails.setTracerReceiverParty(tracerDto.getTracerReceiverParty());
        tracerDetails.setTracerType(tracerDto.getTracerType());
        tracerDetails.setTracerStartDate(tracerDto.getTracerStartDate());
        return tracerDetails;
    }
}
