package com.TradeFinance.LetterOfCredit;

import com.TradeFinance.LetterOfCredit.DocumentsAndShipment.DocumentsRequired;
import com.TradeFinance.LetterOfCredit.DocumentsAndShipment.DocumentsRequiredDto;
import com.TradeFinance.LetterOfCredit.DocumentsAndShipment.ShipmentAndGoods;
import com.TradeFinance.LetterOfCredit.DocumentsAndShipment.ShipmentAndGoodsDto;
import com.TradeFinance.LetterOfCredit.applicant.Applicant;
import com.TradeFinance.LetterOfCredit.beneficiary.Beneficiary;
import com.TradeFinance.LetterOfCredit.collateral.PaymentSecurity;
import com.TradeFinance.LetterOfCredit.collateral.PaymentSecurityDto;
import com.TradeFinance.dto.ApplicantDto;
import com.TradeFinance.dto.BeneficiaryDto;
import com.TradeFinance.dto.LetterOfCreditRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@CrossOrigin("*")
public class MT700Controller {
    private MT700 mt700;

    @Autowired
    private LetterOfCreditRepository letterOfCreditRepository; // Keep this injection as is

    @GetMapping("/generate-mt700/{lcNumber}")
    public ResponseEntity<String> generateMt700(@PathVariable("lcNumber") String lcNumber) {
        Optional<LetterOfCredit> optLetterOfCredit = letterOfCreditRepository.findByLcNumber(lcNumber);

        if (!optLetterOfCredit.isPresent()) {
            return ResponseEntity.notFound().build(); // Handle not found case as needed
        }

        LetterOfCredit letterOfCredit = optLetterOfCredit.get();
        LetterOfCreditRequest locRequest = convertToDto(letterOfCredit); // Convert LetterOfCredit to LetterOfCreditRequest

        // Create a new MT700 instance for each LC number
        try {
            MT700FactoryBean factoryBean = new MT700FactoryBean();
            mt700 = factoryBean.getObject();
            mt700.setLocRequest(locRequest);
            String swiftnetMessage = mt700.message();

            // Return the message
            return ResponseEntity.ok(swiftnetMessage);
        } catch (Exception e) {
            // Handle exceptions appropriately
            return ResponseEntity.badRequest().body("Error generating MT700 message");
        }
    }




    public LetterOfCreditRequest convertToDto(LetterOfCredit letterOfCredit) {
        LetterOfCreditRequest locRequest = LetterOfCreditRequest.builder()
                .cifId(letterOfCredit.getCifId())
                .nationalId(letterOfCredit.getNationalId())
                .accountNumber(letterOfCredit.getAccountNumber())
                .applicantDto(mapToApplicant(letterOfCredit.getApplicant()))
                .beneficiaryDto(mapToBeneficiary(letterOfCredit.getBeneficiary()))
                //.secondaryBeneficiaryDto(map(letterOfCredit.getSecondaryBeneficiary()))
                .lcNumber(letterOfCredit.getLcNumber())
                .lcType(letterOfCredit.getLcType())
                .applicableRules(letterOfCredit.getApplicableRules())
                .issueDate(letterOfCredit.getIssueDate())
                .expiryDate(letterOfCredit.getExpiryDate())
                .tenor(letterOfCredit.getTenor())
                .transferable(letterOfCredit.getTransferable())
                .negotiationPeriod(letterOfCredit.getNegotiationPeriod())
                .chargesBorneBy(letterOfCredit.getChargesBorneBy())
                .transferAmount(letterOfCredit.getTransferAmount())
                .amount(letterOfCredit.getAmount())
                .currencyCode(letterOfCredit.getCurrencyCode())
                .newExpiryDate(letterOfCredit.getNewExpiryDate())
                .creationDate(letterOfCredit.getCreationDate())
                .createdBy(letterOfCredit.getCreatedBy())
                .approvedBy(letterOfCredit.getApprovedBy())
                .approvalDate(letterOfCredit.getApprovalDate())
                .confirm(letterOfCredit.getConfirm())
                .advise(letterOfCredit.getAdvise())
                .status(letterOfCredit.getStatus())
                .documentsRequiredDto(mapToDocumentRequired(letterOfCredit.getDocumentsRequired()))
                .shipmentAndGoodsDto(mapToShipmentsAndGoods(letterOfCredit.getShipmentAndGoods()))
                .paymentSecurityDto(mapToPaymentsSecurity(letterOfCredit.getPaymentSecurity()))
                .build();

        return locRequest;
    }

    private PaymentSecurityDto mapToPaymentsSecurity(PaymentSecurity paymentSecurity) {

        PaymentSecurityDto paymentSecurityDto = new PaymentSecurityDto();
        paymentSecurityDto.setCollateralType(paymentSecurity.getCollateralType());
        paymentSecurityDto.setCollateralValue(paymentSecurity.getCollateralValue());
        paymentSecurityDto.setGuarantorAddress(paymentSecurity.getGuarantorAddress());
        paymentSecurityDto.setGuarantorName(paymentSecurity.getGuarantorName());
        paymentSecurityDto.setGuarantorEmail(paymentSecurity.getGuarantorEmail());
        paymentSecurityDto.setGuarantorPhoneNumber(paymentSecurity.getGuarantorPhoneNumber());
        return paymentSecurityDto;
    }

    private DocumentsRequiredDto mapToDocumentRequired(DocumentsRequired documentsRequired) {
        DocumentsRequiredDto documentsRequiredDto = new DocumentsRequiredDto();
        documentsRequiredDto.setDocumentName1(documentsRequired.getDocumentName1());
        documentsRequiredDto.setDocumentDescription1(documentsRequired.getDocumentDescription1());
        documentsRequiredDto.setDocumentName2(documentsRequired.getDocumentName2());
        documentsRequiredDto.setDocumentDescription2(documentsRequired.getDocumentDescription2());
        documentsRequiredDto.setDocumentName3(documentsRequired.getDocumentName3());
        documentsRequiredDto.setDocumentDescription3(documentsRequired.getDocumentDescription3());
        documentsRequiredDto.setDocumentName4(documentsRequired.getDocumentName4());
        documentsRequiredDto.setDocumentDescription4(documentsRequired.getDocumentDescription4());
        documentsRequiredDto.setDocumentName5(documentsRequired.getDocumentName5());
        documentsRequiredDto.setDocumentDescription5(documentsRequired.getDocumentDescription5());
        documentsRequiredDto.setDocumentName6(documentsRequired.getDocumentName6());
        documentsRequiredDto.setDocumentDescription6(documentsRequired.getDocumentDescription6());
        documentsRequiredDto.setDocumentName7(documentsRequired.getDocumentName7());
        documentsRequiredDto.setDocumentDescription7(documentsRequired.getDocumentDescription7());
        documentsRequiredDto.setDocumentName8(documentsRequired.getDocumentName8());
        documentsRequiredDto.setDocumentDescription8(documentsRequired.getDocumentDescription8());
        documentsRequiredDto.setDocumentName9(documentsRequired.getDocumentName9());
        documentsRequiredDto.setDocumentDescription9(documentsRequired.getDocumentDescription9());
        return documentsRequiredDto;
    }

    private BeneficiaryDto mapToBeneficiary(Beneficiary beneficiary) {
        BeneficiaryDto beneficiaryDto = new BeneficiaryDto();

        beneficiaryDto.setBeneficiaryFirstName(beneficiary.getBeneficiaryFirstName());
        beneficiaryDto.setBeneficiaryMiddleName(beneficiary.getBeneficiaryMiddleName());
        beneficiaryDto.setBeneficiaryLastName(beneficiary.getBeneficiaryLastName());
        beneficiaryDto.setBeneficiaryAccountNumber(beneficiary.getBeneficiaryAccountNumber());
        beneficiaryDto.setBeneficiaryAccountName(beneficiary.getBeneficiaryAccountName());
        beneficiaryDto.setBeneficiaryEmail(beneficiary.getBeneficiaryEmail());
        beneficiaryDto.setBeneficiaryIban(beneficiary.getBeneficiaryIban());
        beneficiaryDto.setBeneficiaryAddressLine1(beneficiary.getBeneficiaryAddressLine1());
        beneficiaryDto.setBeneficiaryAddressLine2(beneficiary.getBeneficiaryAddressLine2());
        beneficiaryDto.setBeneficiaryCity(beneficiary.getBeneficiaryCity());
        beneficiaryDto.setBeneficiaryPostalCode(beneficiary.getBeneficiaryPostalCode());
        beneficiaryDto.setBeneficiaryCountryCode(beneficiary.getBeneficiaryCountryCode());
        beneficiaryDto.setBeneficiaryCountry(beneficiary.getBeneficiaryCountry());
        beneficiaryDto.setAdvisingBankName(beneficiary.getAdvisingBankName());
        beneficiaryDto.setAdvisingBankCountry(beneficiary.getAdvisingBankCountry());
        beneficiaryDto.setAdvisingBankBic(beneficiary.getAdvisingBankBic());
        beneficiaryDto.setAdvisingBankBranch(beneficiary.getAdvisingBankBranch());
        beneficiaryDto.setAdvisingBankBranchCode(beneficiary.getAdvisingBankBranchCode());

        return beneficiaryDto;
    }

    private ApplicantDto mapToApplicant(Applicant applicant) {
        ApplicantDto applicantDto = new ApplicantDto();
        applicantDto.setCifId(applicant.getCifId());
        applicantDto.setAccountNumber(applicant.getAccountNumber());
        applicantDto.setNationalId(applicant.getNationalId());
        applicantDto.setAccountName(applicant.getAccountName());
        applicantDto.setCurrency(applicant.getCurrency());
        applicantDto.setEmail(applicant.getEmail());
        applicantDto.setPhoneNumber(applicant.getPhoneNumber());
        applicantDto.setAddress(applicant.getAddress());
        applicantDto.setCity(applicant.getCity());
        applicantDto.setPostalCode(applicant.getPostalCode());
        applicantDto.setCountryCode(applicant.getCountryCode());
        applicantDto.setCountry(applicant.getCountry());
        applicantDto.setApplicantSwiftCode(applicant.getApplicantSwiftCode());
        return applicantDto;
    }

    private ShipmentAndGoodsDto mapToShipmentsAndGoods(ShipmentAndGoods shipmentAndGoods) {
        ShipmentAndGoodsDto shipmentAndGoodsDto = new ShipmentAndGoodsDto();
        shipmentAndGoodsDto.setShipmentDate(shipmentAndGoods.getShipmentDate());
        shipmentAndGoodsDto.setPortOfDischarge(shipmentAndGoods.getPortOfDischarge());
        shipmentAndGoodsDto.setPortOfLoading(shipmentAndGoods.getPortOfLoading());
        shipmentAndGoodsDto.setShipmentTerms(shipmentAndGoods.getShipmentTerms());
        shipmentAndGoodsDto.setPartialShipment(shipmentAndGoods.getPartialShipment());
        shipmentAndGoodsDto.setTransShipment(shipmentAndGoods.getTransShipment());
        shipmentAndGoodsDto.setCommodityCode(shipmentAndGoods.getCommodityCode());
        shipmentAndGoodsDto.setGoodsQuantity(shipmentAndGoods.getGoodsQuantity());
        shipmentAndGoodsDto.setPricePerUnit(shipmentAndGoods.getPricePerUnit());
        shipmentAndGoodsDto.setCountryOfOrigin(shipmentAndGoods.getCountryOfOrigin());
        return shipmentAndGoodsDto;

    }


}