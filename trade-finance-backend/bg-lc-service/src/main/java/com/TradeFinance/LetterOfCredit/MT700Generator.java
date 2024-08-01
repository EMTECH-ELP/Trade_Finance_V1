//package com.TradeFinance.LetterOfCredit;
//
//import com.fasterxml.jackson.databind.ObjectMapper;
//import org.springframework.stereotype.Component;
//
//@Component
//public class MT700Generator {
//     mt700Message.getTags().put(":27:", request.getAccountResponse().getAccountNumber());
//        mt700Message.getTags().put(":28C:", request.getBeneficiaryDto().getAdvisingBankBic());
//    // mt700Message.getTags().put(":27:", request.getOneByOne().toString());
//        mt700Message.getTags().put(":40A:", request.getLcType());
//        mt700Message.getTags().put(":20:", request.getLcNumber());
//        mt700Message.getTags().put(":23B:", request.getAdvise());
//        mt700Message.getTags().put(":31C:", request.getIssueDate().toString());
//        mt700Message.getTags().put(":40E:", request.getApplicableRules());
//        mt700Message.getTags().put(":31D:", request.getExpiryDate().toString());
//        mt700Message.getTags().put(":51A:", request.getAccountResponse().getAddress());
//        mt700Message.getTags().put(":50:", request.getAccountResponse().getAccountName());
//        mt700Message.getTags().put(":59:", request.getBeneficiaryDto().getBeneficiaryAccountName());
//        mt700Message.getTags().put(":32B:", request.getCurrencyCode() + request.getAmount().doubleValue());
//    //mt700Message.getTags().put(":41A:", request.getIssuingBank());
//        mt700Message.getTags().put(":44E:", request.getShipmentAndGoodsDto().getPortOfLoading());
//        mt700Message.getTags().put(":44F:", request.getShipmentAndGoodsDto().getPortOfLoading());
//        mt700Message.getTags().put(":42C:", request.getShipmentAndGoodsDto().getShipmentDate().toString());
//        mt700Message.getTags().put(":42A:", request.getShipmentAndGoodsDto().getShipmentTerms());
//        mt700Message.getTags().put(":43P:", request.getShipmentAndGoodsDto().getPartialShipment());
//        mt700Message.getTags().put(":42T:", request.getShipmentAndGoodsDto().getTransShipment());
//        mt700Message.getTags().put(":43P:", request.getShipmentAndGoodsDto().getCountryOfOrigin());
//        mt700Message.getTags().put(":44A:", request.getTenor());
//        mt700Message.getTags().put(":45A:", request.getDocumentsRequiredDto().getDocumentDescription1());
//        mt700Message.getTags().put(":46A:", request.getDocumentName());
//        mt700Message.getTags().put(":49G:", request.getShipmentTerms());
//        mt700Message.getTags().put(":71D:", request.getChargesBorneBy());
//        mt700Message.getTags().put(":47A:", request.getNegotiationPeriod().toString());
//        mt700Message.getTags().put(":49:", request.getConfirm());
//
//    // Convert mt700Message to JSON
//    ObjectMapper objectMapper = new ObjectMapper();
//    String json = objectMapper.writeValueAsString(mt700Message);
//        return json;
//}
