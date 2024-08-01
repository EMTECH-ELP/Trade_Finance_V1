package com.TradeFinance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class SecondaryBeneficiaryDto {
        private String firstName;
        private String middleName;
        private String lastName;
        private String accountNumber;
        private String iban;
        private String countryCode;
        private String country;
        private String address;
        private String advisingBank;
        private String advisingBankCountry;
        private String advisingBankBic;
}
