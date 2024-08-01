package com.TradeFinance.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class AccountResponse {
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
    //@JsonIgnore
    // private bankDto bank;
    @JsonIgnore
    private String formattedAddress;
}
