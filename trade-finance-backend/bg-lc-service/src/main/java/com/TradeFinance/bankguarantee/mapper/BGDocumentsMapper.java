package com.TradeFinance.bankguarantee.mapper;



import com.TradeFinance.bankguarantee.dto.BGDocumentsRequiredDto;
import com.TradeFinance.bankguarantee.entity.BGDocumentsRequired;

public class BGDocumentsMapper {
    public static BGDocumentsRequired mapToDocumentsRequired(BGDocumentsRequiredDto documentsRequiredDto) {
        BGDocumentsRequired documentsRequired = new BGDocumentsRequired();
        documentsRequired.setDocumentName1(documentsRequiredDto.getDocumentName1());
        documentsRequired.setDocumentDescription1(documentsRequiredDto.getDocumentDescription1());
        documentsRequired.setDocumentName2(documentsRequiredDto.getDocumentName2());
        documentsRequired.setDocumentDescription2(documentsRequiredDto.getDocumentDescription2());
        documentsRequired.setDocumentName3(documentsRequiredDto.getDocumentName3());
        documentsRequired.setDocumentDescription3(documentsRequiredDto.getDocumentDescription3());
        documentsRequired.setDocumentName4(documentsRequiredDto.getDocumentName4());
        documentsRequired.setDocumentDescription4(documentsRequiredDto.getDocumentDescription4());
        documentsRequired.setDocumentName5(documentsRequiredDto.getDocumentName5());
        documentsRequired.setDocumentDescription5(documentsRequiredDto.getDocumentDescription5());
        documentsRequired.setDocumentName6(documentsRequiredDto.getDocumentName6());
        documentsRequired.setDocumentDescription6(documentsRequiredDto.getDocumentDescription6());
        documentsRequired.setDocumentName7(documentsRequiredDto.getDocumentName7());
        documentsRequired.setDocumentDescription7(documentsRequiredDto.getDocumentDescription7());
        documentsRequired.setDocumentName8(documentsRequiredDto.getDocumentName8());
        documentsRequired.setDocumentDescription8(documentsRequiredDto.getDocumentDescription8());
        documentsRequired.setDocumentName9(documentsRequiredDto.getDocumentName9());
        documentsRequired.setDocumentDescription9(documentsRequiredDto.getDocumentDescription9());
        return documentsRequired;
    }

}

