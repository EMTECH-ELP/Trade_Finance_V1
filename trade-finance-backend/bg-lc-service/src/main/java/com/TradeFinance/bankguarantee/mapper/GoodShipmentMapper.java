package com.TradeFinance.bankguarantee.mapper;

import com.TradeFinance.LetterOfCredit.DocumentsAndShipment.ShipmentAndGoods;
import com.TradeFinance.LetterOfCredit.DocumentsAndShipment.ShipmentAndGoodsDto;

//
//import com.TradeFinance.bankguarantee.dto.GoodsShipmentDto;
//import com.TradeFinance.bankguarantee.entities.GoodsShipment;
//
public class GoodShipmentMapper {

    public static ShipmentAndGoods mapToShipmentAndGoods(ShipmentAndGoodsDto shipmentAndGoodsDto) {
        ShipmentAndGoods shipmentAndGoods = new ShipmentAndGoods();
        shipmentAndGoods.setShipmentDate(shipmentAndGoodsDto.getShipmentDate());
        shipmentAndGoods.setPortOfDischarge(shipmentAndGoodsDto.getPortOfDischarge());
        shipmentAndGoods.setPortOfLoading(shipmentAndGoodsDto.getPortOfLoading());
        shipmentAndGoods.setShipmentTerms(shipmentAndGoodsDto.getShipmentTerms());
        shipmentAndGoods.setPartialShipment(shipmentAndGoodsDto.getPartialShipment());
        shipmentAndGoods.setTransShipment(shipmentAndGoodsDto.getTransShipment());
        shipmentAndGoods.setCommodityCode(shipmentAndGoodsDto.getCommodityCode());
        shipmentAndGoods.setGoodsQuantity(shipmentAndGoodsDto.getGoodsQuantity());
        shipmentAndGoods.setPricePerUnit(shipmentAndGoodsDto.getPricePerUnit());
        shipmentAndGoods.setCountryOfOrigin(shipmentAndGoodsDto.getCountryOfOrigin());
        return shipmentAndGoods;
    }
}
