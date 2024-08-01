//package com.TradeFinance.LetterOfCredit.beneficiary;
//
//import com.TradeFinance.LetterOfCredit.applicant.BGApplicant;
//import com.TradeFinance.dto.ApplicantDto;
//import com.TradeFinance.dto.BeneficiaryDto;
//
//public class BeneficiaryMapper {
//    public static Beneficiary mapToBeneficiary(BeneficiaryDto beneficiaryDto) {
//        Beneficiary beneficiaryDetails = new Beneficiary();
//
//        beneficiaryDetails.setBeneficiaryFirstName(beneficiaryDto.getBeneficiaryFirstName());
//        beneficiaryDetails.setBeneficiaryMiddleName(beneficiaryDto.getBeneficiaryMiddleName());
//        beneficiaryDetails.setBeneficiaryLastName(beneficiaryDto.getBeneficiaryLastName());
//        beneficiaryDetails.setBeneficiaryAccountNumber(beneficiaryDto.getBeneficiaryAccountNumber());
//        beneficiaryDetails.setBeneficiaryAccountName(beneficiaryDto.getBeneficiaryAccountName());
//        beneficiaryDetails.setBeneficiaryEmail(beneficiaryDto.getBeneficiaryEmail());
//        beneficiaryDetails.setBeneficiaryIban(beneficiaryDto.getBeneficiaryIban());
//        beneficiaryDetails.setBeneficiaryAddressLine1(beneficiaryDto.getBeneficiaryAddressLine1());
//        beneficiaryDetails.setBeneficiaryAddressLine2(beneficiaryDto.getBeneficiaryAddressLine2());
//        beneficiaryDetails.setBeneficiaryCity(beneficiaryDto.getBeneficiaryCity());
//        beneficiaryDetails.setBeneficiaryPostalCode(beneficiaryDto.getBeneficiaryPostalCode());
//        beneficiaryDetails.setBeneficiaryCountryCode(beneficiaryDto.getBeneficiaryCountryCode());
//        beneficiaryDetails.setBeneficiaryCountry(beneficiaryDto.getBeneficiaryCountry());
//        beneficiaryDetails.setAdvisingBankName(beneficiaryDto.getAdvisingBankName());
//        beneficiaryDetails.setAdvisingBankCountry(beneficiaryDto.getAdvisingBankCountry());
//        beneficiaryDetails.setAdvisingBankBic(beneficiaryDto.getAdvisingBankBic());
//        beneficiaryDetails.setAdvisingBankBranch(beneficiaryDto.getAdvisingBankBranch());
//        beneficiaryDetails.setAdvisingBankBranchCode(beneficiaryDto.getAdvisingBankBranchCode());
//
//        return beneficiaryDetails;
//    }
//}
