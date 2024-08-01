package com.TradeFinance.bankguarantee.mapper;



import com.TradeFinance.bankguarantee.dto.BGShipmentAndGoodsDto;
import com.TradeFinance.bankguarantee.entity.BGShipmentAndGoods;

import java.text.SimpleDateFormat;
import java.util.Date;

public class BGShipmentAndGoodsMapper {
    public static BGShipmentAndGoods mapToShipmentAndGoods(BGShipmentAndGoodsDto shipmentAndGoodsDto) {
        BGShipmentAndGoods shipmentAndGoods = new BGShipmentAndGoods();
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
