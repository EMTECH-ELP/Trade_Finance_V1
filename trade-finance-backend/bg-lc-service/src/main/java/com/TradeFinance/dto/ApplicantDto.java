package com.TradeFinance.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicantDto {
    private String cifId;
    private String accountNumber;
    private String nationalId;
    private String accountName;
    private String currency;
    private String email;
    private String phoneNumber;
    private String address;
    private String city;
    private String postalCode;
    private String countryCode;
    private String country;
    private String applicantSwiftCode;

}
