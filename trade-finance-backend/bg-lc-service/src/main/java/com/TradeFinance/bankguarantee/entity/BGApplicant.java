package com.TradeFinance.bankguarantee.entity;


import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Bg_Applicant")
public class BGApplicant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "cif_id")
    private String cifId;
    private String nationalId;
    private String applicantName;
    @Column(name = "address")
    private String address;
    @Column(name = "postalCode")
    private String postalCode;
    @Column(name = "city")
    private String city;
    @Column(name = "formatted_address")
    private String formattedAddress;
    @Column(name = "account_number")
    private String accountNumber;
    @Column(name = "account_balance")
    private BigDecimal accountBalance;
    private String accountName;
    private String currency;
    @Column(name = "email")
    private String email;
    @Column(name = "phone_number")
    private String phoneNumber;
    private String countryCode;
    @Column(name = "country")
    private String country;
    //private String applicantSwiftCode;
    @OneToOne(mappedBy = "applicant")
    @JsonBackReference
    private BankGuarantee bankGuarantee;
}
