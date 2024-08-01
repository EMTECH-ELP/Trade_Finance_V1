package com.TradeFinance.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder

public class BeneficiaryDto {
    private String beneficiaryFirstName;
    private String beneficiaryMiddleName;
    private String beneficiaryLastName;
    private String beneficiaryAccountNumber;
    private String beneficiaryAccountName;
    private String beneficiaryEmail;
    private String beneficiaryIban;
    private String beneficiaryAddressLine1;
    private String beneficiaryAddressLine2;
    private String beneficiaryCity;
    private String beneficiaryPostalCode;
    private String beneficiaryCountryCode;
    private String beneficiaryCountry;
    private String advisingBankName;
    private String advisingBankCountry;
    private String advisingBankBic;
    private String advisingBankBranch;
    private String advisingBankBranchCode;
    @JsonIgnore
    private String formattedAddress;


}
