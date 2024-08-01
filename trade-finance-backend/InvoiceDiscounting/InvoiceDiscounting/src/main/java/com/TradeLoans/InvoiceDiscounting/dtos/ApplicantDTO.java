package com.TradeLoans.InvoiceDiscounting.dtos;

import lombok.*;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApplicantDTO {
    private String accountNumber;
    private String cifId;
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
    private List<InvoiceDTO> invoices;
}
