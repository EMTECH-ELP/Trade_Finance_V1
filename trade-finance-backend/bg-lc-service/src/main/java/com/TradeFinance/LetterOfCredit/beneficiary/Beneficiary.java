package com.TradeFinance.LetterOfCredit.beneficiary;

import com.TradeFinance.LetterOfCredit.LetterOfCredit;
import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Entity
@Table(name = "Lc_Beneficiary")

public class Beneficiary {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name = "first_name")
    private String beneficiaryFirstName;
    @Column(name = "middle_name")
    private String beneficiaryMiddleName;
    @Column(name = "last_name")
    private String beneficiaryLastName;
    @Column(name = "account_number")
    private String beneficiaryAccountNumber;
    @Column(name = "account_name")
    private String beneficiaryAccountName;
    @Column(name = "iban")
    private String beneficiaryIban;
    @Column(name = "beneficiary_email")
    private String beneficiaryEmail;
    @Column(name = "country_code")
    private String beneficiaryCountryCode;
    @Column(name = "country")
    private String beneficiaryCountry;
    @Column(name = "address_line_1")
    private String beneficiaryAddressLine1;
    @Column(name = "address_line_2")
    private String beneficiaryAddressLine2;
    @Column(name = "city")
    private String beneficiaryCity;
    @Column(name = "postal_code")
    private String beneficiaryPostalCode;
    @Column(name = "advising_bank_name")
    private String advisingBankName;
    @Column(name = "advising_bank_country")
    private String advisingBankCountry;
    @Column(name = "advising_bank_bic")
    private String advisingBankBic;
    private String advisingBankBranch;
    private String advisingBankBranchCode;
    @OneToOne(mappedBy = "beneficiary")
    @JsonBackReference
    private LetterOfCredit letterOfCredit;
}
