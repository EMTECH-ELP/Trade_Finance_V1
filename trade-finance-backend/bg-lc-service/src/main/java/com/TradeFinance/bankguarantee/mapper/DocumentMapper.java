//package com.TradeFinance.bankguarantee.mapper;
//
//import com.TradeFinance.bankguarantee.dto.DocumentsRequiredDto;
//import com.TradeFinance.bankguarantee.dto.ShipmentAndGoodsDto;
//import com.TradeFinance.bankguarantee.entity.DocumentsRequiredBG;
//import com.TradeFinance.bankguarantee.entity.ShipmentAndGoodsBG;
//
//public class DocumentMapper {
//    public static DocumentsRequiredBG mapToDocumentsRequired(DocumentsRequiredDto documentsRequiredDto) {
//        DocumentsRequiredBG documentsRequired = new DocumentsRequiredBG();
//        documentsRequired.setDocumentName1(documentsRequiredDto.getDocumentName1());
//        documentsRequired.setDocumentDescription1(documentsRequiredDto.getDocumentDescription1());
//        documentsRequired.setDocumentName2(documentsRequiredDto.getDocumentName2());
//        documentsRequired.setDocumentDescription2(documentsRequiredDto.getDocumentDescription2());
//        documentsRequired.setDocumentName3(documentsRequiredDto.getDocumentName3());
//        documentsRequired.setDocumentDescription3(documentsRequiredDto.getDocumentDescription3());
//        documentsRequired.setDocumentName4(documentsRequiredDto.getDocumentName4());
//        documentsRequired.setDocumentDescription4(documentsRequiredDto.getDocumentDescription4());
//        documentsRequired.setDocumentName5(documentsRequiredDto.getDocumentName5());
//        documentsRequired.setDocumentDescription5(documentsRequiredDto.getDocumentDescription5());
//        documentsRequired.setDocumentName6(documentsRequiredDto.getDocumentName6());
//        documentsRequired.setDocumentDescription6(documentsRequiredDto.getDocumentDescription6());
//        documentsRequired.setDocumentName7(documentsRequiredDto.getDocumentName7());
//        documentsRequired.setDocumentDescription7(documentsRequiredDto.getDocumentDescription7());
//        documentsRequired.setDocumentName8(documentsRequiredDto.getDocumentName8());
//        documentsRequired.setDocumentDescription8(documentsRequiredDto.getDocumentDescription8());
//        documentsRequired.setDocumentName9(documentsRequiredDto.getDocumentName9());
//        documentsRequired.setDocumentDescription9(documentsRequiredDto.getDocumentDescription9());
//        return documentsRequired;
//    }
////    public static DocumentsRequiredDto mapToDocumentsRequiredDto(DocumentsRequiredBG documentsRequired) {
////        DocumentsRequiredDto documentsRequiredDto = new DocumentsRequiredDto();
////        documentsRequiredDto.setDocumentName1(documentsRequired.getDocumentName1());
////        documentsRequiredDto.setDocumentDescription1(documentsRequired.getDocumentDescription1());
////        documentsRequiredDto.setDocumentName2(documentsRequired.getDocumentName2());
////        documentsRequiredDto.setDocumentDescription2(documentsRequired.getDocumentDescription2());
////        documentsRequiredDto.setDocumentName3(documentsRequired.getDocumentName3());
////        documentsRequiredDto.setDocumentDescription3(documentsRequired.getDocumentDescription3());
////        documentsRequiredDto.setDocumentName4(documentsRequired.getDocumentName4());
////        documentsRequiredDto.setDocumentDescription4(documentsRequired.getDocumentDescription4());
////        documentsRequiredDto.setDocumentName5(documentsRequired.getDocumentName5());
////        documentsRequiredDto.setDocumentDescription5(documentsRequired.getDocumentDescription5());
////        documentsRequiredDto.setDocumentName6(documentsRequired.getDocumentName6());
////        documentsRequiredDto.setDocumentDescription6(documentsRequired.getDocumentDescription6());
////        documentsRequiredDto.setDocumentName7(documentsRequired.getDocumentName7());
////        documentsRequiredDto.setDocumentDescription7(documentsRequired.getDocumentDescription7());
////        documentsRequiredDto.setDocumentName8(documentsRequired.getDocumentName8());
////        documentsRequiredDto.setDocumentDescription8(documentsRequired.getDocumentDescription8());
////        documentsRequiredDto.setDocumentName9(documentsRequired.getDocumentName9());
////        documentsRequiredDto.setDocumentDescription9(documentsRequired.getDocumentDescription9());
////        return documentsRequiredDto;
////    }
//
//
//    public static ShipmentAndGoodsBG mapToShipmentAndGoods(ShipmentAndGoodsDto shipmentAndGoodsDto) {
//        ShipmentAndGoodsBG shipmentAndGoods = new ShipmentAndGoodsBG();
//        shipmentAndGoods.setShipmentDate(shipmentAndGoodsDto.getShipmentDate());
//        shipmentAndGoods.setPortOfDischarge(shipmentAndGoodsDto.getPortOfDischarge());
//        shipmentAndGoods.setPortOfLoading(shipmentAndGoodsDto.getPortOfLoading());
//        shipmentAndGoods.setShipmentTerms(shipmentAndGoodsDto.getShipmentTerms());
//        shipmentAndGoods.setPartialShipment(shipmentAndGoodsDto.getPartialShipment());
//        shipmentAndGoods.setTransShipment(shipmentAndGoodsDto.getTransShipment());
//        shipmentAndGoods.setCommodityCode(shipmentAndGoodsDto.getCommodityCode());
//        shipmentAndGoods.setGoodsQuantity(shipmentAndGoodsDto.getGoodsQuantity());
//        shipmentAndGoods.setPricePerUnit(shipmentAndGoodsDto.getPricePerUnit());
//        shipmentAndGoods.setCountryOfOrigin(shipmentAndGoodsDto.getCountryOfOrigin());
//        return shipmentAndGoods;
//    }
////    public static ShipmentAndGoodsDto mapToShipmentAndGoodsDto(ShipmentAndGoodsBG shipmentAndGoods) {
////        ShipmentAndGoodsDto shipmentAndGoodsDto = new ShipmentAndGoodsDto();
////        shipmentAndGoodsDto.setShipmentDate(shipmentAndGoods.getShipmentDate());
////        shipmentAndGoodsDto.setPortOfDischarge(shipmentAndGoods.getPortOfDischarge());
////        shipmentAndGoodsDto.setPortOfLoading(shipmentAndGoods.getPortOfLoading());
////        shipmentAndGoodsDto.setShipmentTerms(shipmentAndGoods.getShipmentTerms());
////        shipmentAndGoodsDto.setPartialShipment(shipmentAndGoods.getPartialShipment());
////        shipmentAndGoodsDto.setTransShipment(shipmentAndGoods.getTransShipment());
////        shipmentAndGoodsDto.setCommodityCode(shipmentAndGoods.getCommodityCode());
////        shipmentAndGoodsDto.setGoodsQuantity(shipmentAndGoods.getGoodsQuantity());
////        shipmentAndGoodsDto.setPricePerUnit(shipmentAndGoods.getPricePerUnit());
////        shipmentAndGoodsDto.setCountryOfOrigin(shipmentAndGoods.getCountryOfOrigin());
////        return shipmentAndGoodsDto;
////    }
//
//}
