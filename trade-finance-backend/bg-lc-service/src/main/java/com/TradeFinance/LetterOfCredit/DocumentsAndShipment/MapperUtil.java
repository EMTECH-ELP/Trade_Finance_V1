package com.TradeFinance.LetterOfCredit.DocumentsAndShipment;

import com.TradeFinance.LetterOfCredit.applicant.Applicant;
import com.TradeFinance.LetterOfCredit.beneficiary.Beneficiary;
import com.TradeFinance.LetterOfCredit.collateral.PaymentSecurity;
import com.TradeFinance.LetterOfCredit.collateral.PaymentSecurityDto;
import com.TradeFinance.dto.ApplicantDto;
import com.TradeFinance.dto.BeneficiaryDto;

public class MapperUtil {
    public static DocumentsRequired mapToDocumentsRequired(DocumentsRequiredDto documentsRequiredDto) {
        DocumentsRequired documentsRequired = new DocumentsRequired();
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
    public static Beneficiary mapToBeneficiary(BeneficiaryDto beneficiaryDto) {
        Beneficiary beneficiaryDetails = new Beneficiary();

        beneficiaryDetails.setBeneficiaryFirstName(beneficiaryDto.getBeneficiaryFirstName());
        beneficiaryDetails.setBeneficiaryMiddleName(beneficiaryDto.getBeneficiaryMiddleName());
        beneficiaryDetails.setBeneficiaryLastName(beneficiaryDto.getBeneficiaryLastName());
        beneficiaryDetails.setBeneficiaryAccountNumber(beneficiaryDto.getBeneficiaryAccountNumber());
        beneficiaryDetails.setBeneficiaryAccountName(beneficiaryDto.getBeneficiaryAccountName());
        beneficiaryDetails.setBeneficiaryEmail(beneficiaryDto.getBeneficiaryEmail());
        beneficiaryDetails.setBeneficiaryIban(beneficiaryDto.getBeneficiaryIban());
        beneficiaryDetails.setBeneficiaryAddressLine1(beneficiaryDto.getBeneficiaryAddressLine1());
        beneficiaryDetails.setBeneficiaryAddressLine2(beneficiaryDto.getBeneficiaryAddressLine2());
        beneficiaryDetails.setBeneficiaryCity(beneficiaryDto.getBeneficiaryCity());
        beneficiaryDetails.setBeneficiaryPostalCode(beneficiaryDto.getBeneficiaryPostalCode());
        beneficiaryDetails.setBeneficiaryCountryCode(beneficiaryDto.getBeneficiaryCountryCode());
        beneficiaryDetails.setBeneficiaryCountry(beneficiaryDto.getBeneficiaryCountry());
        beneficiaryDetails.setAdvisingBankName(beneficiaryDto.getAdvisingBankName());
        beneficiaryDetails.setAdvisingBankCountry(beneficiaryDto.getAdvisingBankCountry());
        beneficiaryDetails.setAdvisingBankBic(beneficiaryDto.getAdvisingBankBic());
        beneficiaryDetails.setAdvisingBankBranch(beneficiaryDto.getAdvisingBankBranch());
        beneficiaryDetails.setAdvisingBankBranchCode(beneficiaryDto.getAdvisingBankBranchCode());

        return beneficiaryDetails;
    }
    public static Applicant mapToApplicant(ApplicantDto applicantDto) {
        if (applicantDto == null) {
            throw new IllegalArgumentException("BGApplicant DTO cannot be null");
        }
        Applicant applicant = new Applicant();
        applicant.setCifId(applicantDto.getCifId());
        applicant.setAccountNumber(applicantDto.getAccountNumber());
        applicant.setNationalId(applicantDto.getNationalId());
        applicant.setAccountName(applicantDto.getAccountName());
        applicant.setCurrency(applicantDto.getCurrency());
        applicant.setEmail(applicantDto.getEmail());
        applicant.setPhoneNumber(applicantDto.getPhoneNumber());
        applicant.setAddress(applicantDto.getAddress());
        applicant.setCity(applicantDto.getCity());
        applicant.setPostalCode(applicantDto.getPostalCode());
        applicant.setCountryCode(applicantDto.getCountryCode());
        applicant.setCountry(applicantDto.getCountry());
        applicant.setApplicantSwiftCode(applicantDto.getApplicantSwiftCode());
        return applicant;
    }
    public static PaymentSecurity mapToPaymentSecurity(PaymentSecurityDto paymentSecurityDto) {
        PaymentSecurity paymentSecurity = new PaymentSecurity();
        paymentSecurity.setCollateralType(paymentSecurityDto.getCollateralType());
        paymentSecurity.setCollateralValue(paymentSecurityDto.getCollateralValue());
        paymentSecurity.setGuarantorAddress(paymentSecurityDto.getGuarantorAddress());
        paymentSecurity.setGuarantorName(paymentSecurityDto.getGuarantorName());
        paymentSecurity.setGuarantorEmail(paymentSecurityDto.getGuarantorEmail());
        paymentSecurity.setGuarantorPhoneNumber(paymentSecurityDto.getGuarantorPhoneNumber());
        return paymentSecurity;
    }

}
